package pe.com.monitoreo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import pe.com.monitoreo.config.DBConfig;
import pe.com.monitoreo.entity.Person;
import pe.com.monitoreo.entity.User;
import pe.com.monitoreo.service.MonitoreoService;
import pe.com.monitoreo.service.PersonService;

/**
 * 
 * @author lcastro
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = DBConfig.class)
public class MonitoreoTest {

	@Autowired
	private PersonService personService;

	@Autowired
	private MonitoreoService monitoreoService;

	@Test
	public void addPersonTest() {
		Person person = null;
		try {
			person = new Person("Luis", "Castro", "luis.castro.j2s@gmail.com");
			personService.add(person);
			Assert.assertTrue(Boolean.TRUE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void listPersonTest() {
		List<Person> persons = null;
		try {
			persons = personService.listPersons();
			if (persons != null && !persons.isEmpty()) {
				Assert.assertNotNull(persons);
			} else {
				Assert.fail("person list empty");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void addUsuarioTest() {
		User user = null;
		try {
			user = new User("password","gluiscastro@gmail.com","luis.castro");
			monitoreoService.saveUser(user);
			Assert.assertTrue(Boolean.TRUE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void findAllUsersTest() {
		List<User> users = null;
		try {
			users = monitoreoService.findAllUsers();
			for (User user : users) {
				System.out.println(user.toString());
			}
			Assert.assertNotNull(users);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void findUsuarioByUserNameTest() {
		List<User> users = null;
		try {
			users = monitoreoService.findUsuarioByUserName("luis.castro");
			for (User user : users) {
				System.out.println(user.toString());
			}
			Assert.assertNotNull(users);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
