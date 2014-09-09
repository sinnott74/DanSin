package dansin.test.ejb;

import javax.ejb.Remote;

@Remote
public interface TestBeanRemote {
	public String helloWorld(String name);
}
