package dansin.test.ejb;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class TestBean
 */
@Stateless(mappedName="dansin.test.ejb.TestBean")
public class TestBean implements TestBeanRemote {

    /**
     * Default constructor. 
     */
    public TestBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String helloWorld(String name) {
		// TODO Auto-generated method stub
		return "Hello "+name;
	}

}
