package dansin.login;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import dansin.facade.authenticate.LoginFacadeRemoteIntf;

public class LoginAction extends ActionSupport implements Preparable {

	LoginFacadeRemoteIntf loginFacade;
	String username;
	String password;

	public void getEJB() throws NamingException {

		Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.apache.openejb.client.RemoteInitialContextFactory");
		prop.put("java.naming.provider.url", "ejbd://localhost:4201");
		Context context = new InitialContext(prop);
		loginFacade = (LoginFacadeRemoteIntf) context
				.lookup("dansin.facade.authenticate.LoginFacade");
	}

	@Override
	public void prepare() throws Exception {
		getEJB();
	}

	@Override
	public String execute() {

		if(loginFacade.authenticate(username, password) == true){
			return SUCCESS;
		}
		return ERROR;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
