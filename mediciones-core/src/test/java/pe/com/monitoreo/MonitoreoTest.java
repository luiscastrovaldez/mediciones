package pe.com.monitoreo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import pe.com.monitoreo.config.MonitoreoConfig;
import pe.com.monitoreo.entity.Person;
import pe.com.monitoreo.entity.Usuario;
import pe.com.monitoreo.service.MonitoreoService;
import pe.com.monitoreo.service.PersonService;

/**
 * 
 * @author lcastro
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = MonitoreoConfig.class)
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
		Usuario usuario = null;
		try {
			usuario = new Usuario("Luis Alberto", "Castro Valdez", "gluiscastro@gmail.com", "clave");
			monitoreoService.saveUsuario(usuario);
			Assert.assertTrue(Boolean.TRUE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void listatoUsuariosTest() {
		List<Usuario> usuarios = null;
		try {
			usuarios = monitoreoService.listarUsuarios();
			for (Usuario usuario : usuarios) {
				System.out.println(usuario.toString());
			}
			Assert.assertNotNull(usuarios);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
