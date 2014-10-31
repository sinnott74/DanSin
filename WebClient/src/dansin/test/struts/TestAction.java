package dansin.test.struts;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import dansin.test.ejb.TestBean;
import dansin.test.ejb.TestBeanRemote;

public class TestAction extends ActionSupport implements Preparable {

	TestBeanRemote testBeanRemote;

	public String TestGuice() {
		if ((testBeanRemote.helloWorld("Daniel")).contains("Daniel")) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public void getEJB() throws NamingException{
		
		Properties prop=new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");
		prop.put("java.naming.provider.url", "ejbd://localhost:4201");
		Context context = new InitialContext(prop);
		testBeanRemote =(TestBeanRemote)context.lookup(TestBean.class.getName());
	}

	@Override
	public void prepare() throws Exception {
		getEJB();
	}
}
