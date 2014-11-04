package dansin.interceptors.ejb;

import java.lang.reflect.Field;
import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class EJBInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 6562306000097938512L;
	private String context = new String();
	private boolean debug = false;

	public void setContext(String context) {
		this.context = context;
	}

	public String getContext() {
		return context;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public boolean isDebug() {
		return debug;
	}

	@Override
	public String intercept(ActionInvocation invocation)
			throws ClassCastException, Exception {
		Object action = invocation.getAction();
		for (Field field : action.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(EJB.class)) {
				Properties prop=new Properties();
				prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");
				prop.put("java.naming.provider.url", "ejbd://localhost:4201");
				InitialContext initialContext = new InitialContext(prop);
				String mappedName = field.getAnnotation(EJB.class).mappedName();
				Object ejb = null;
				if (null != mappedName && 0 != mappedName.trim().length()) {
					try {
						if (debug) {
							System.out.println("Lookup " + mappedName.trim());
						}
						ejb = initialContext.lookup(mappedName.trim());
					} catch (NamingException e) {

					}
				} else {
					try {
						if (debug) {
							System.out.println("Lookup "
									+ field.getType().getSimpleName());
						}
						ejb = initialContext.lookup(field.getType()
								.getSimpleName());
					} catch (NamingException e) {

					}
					if (null == ejb) {
						try {
							if (debug) {
								System.out.println("Lookup "
										+ field.getType().getName());
							}
							ejb = initialContext.lookup(field.getType()
									.getName());
						} catch (NamingException e) {

						}
					}
					if (null == ejb) {
						ejb = lookup(initialContext, context.split(","), field);
					}

					if (null == ejb) {
						ejb = lookup(initialContext, initialContext.list(""),
								field, true);
					}
				}

				if (null != ejb) {
					boolean wasAccessable = field.isAccessible();
					field.setAccessible(true);
					field.set(action, field.getType().cast(ejb));
					field.setAccessible(wasAccessable);
				}
			}
		}
		return invocation.invoke();
	}

	private Object lookup(InitialContext initialContext, String[] contexts,
			Field field) {
		Object ejb = null;
		for (String context : contexts) {
			try {
				if (debug) {
					System.out.println("Lookup "
							+ (context.endsWith("/") ? context.substring(0,
									context.lastIndexOf("/")) : context) + "/"
							+ field.getType().getName());
				}
				ejb = initialContext.lookup((context.endsWith("/") ? context
						.substring(0, context.lastIndexOf("/")) : context)
						+ "/" + field.getType().getName());
			} catch (NamingException e) {
			}

			if (null == ejb) {
				try {
					if (debug) {
						System.out.println("Lookup "
								+ (context.endsWith("/") ? context.substring(0,
										context.lastIndexOf("/")) : context)
								+ "/" + field.getType().getSimpleName());
					}
					ejb = initialContext
							.lookup((context.endsWith("/") ? context.substring(
									0, context.lastIndexOf("/")) : context)
									+ "/" + field.getType().getSimpleName());
				} catch (NamingException e) {
				}
			}

			if (null != ejb) {
				break;
			}

			ejb = null;
		}

		return ejb;
	}

	private Object lookup(InitialContext initialContext,
			NamingEnumeration<NameClassPair> namingEnumeration, Field field,
			boolean recurse) {
		Object ejb = null;
		try {
			while (namingEnumeration.hasMore()) {
				NameClassPair next;
				try {
					next = namingEnumeration.next();
				} catch (NamingException e) {
					continue;
				}

				if (null == next) {
					continue;
				}

				try {
					if (debug) {
						System.out.println("Lookup " + next.getName() + "/"
								+ field.getType().getName());
					}
					ejb = initialContext.lookup(next.getName() + "/"
							+ field.getType().getName());
				} catch (NamingException e) {
				}

				if (null == ejb) {
					try {
						if (debug) {
							System.out.println("Lookup " + next.getName() + "/"
									+ field.getType().getSimpleName());
						}
						ejb = initialContext.lookup(next.getName() + "/"
								+ field.getType().getSimpleName());
					} catch (NamingException e) {
					}
				}

				if (null == ejb && recurse) {
					return lookup(initialContext,
							initialContext.list(next.getName()), field, recurse);
				}

				if (null != ejb) {
					break;
				}

				ejb = null;
			}
		} catch (NamingException e) {
		}

		return ejb;
	}
}
