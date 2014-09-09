package dansin.facade.authenticate;

import javax.ejb.Remote;

@Remote
public interface LoginFacadeRemoteIntf {

	boolean authenticate(String username, String password);
}
