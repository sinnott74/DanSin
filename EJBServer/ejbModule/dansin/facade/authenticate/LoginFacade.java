package dansin.facade.authenticate;

import javax.ejb.Stateless;

import com.thumbwar.entity.User;
import com.thumbwar.entityDAO.UserDAO;

@Stateless(mappedName="dansin.facade.authenticate.LoginFacade")
public class LoginFacade implements LoginFacadeRemoteIntf {

	@Override
	public boolean authenticate(String username, String password) {
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findByUsername(username);
		if (user.getPassword().equals(password)){
			return true;
		}
		return false;
	}
}
