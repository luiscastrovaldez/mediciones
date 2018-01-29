package pe.com.mediciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pe.com.mediciones.bean.Response;
import pe.com.monitoreo.entity.User;
import pe.com.monitoreo.service.MeasureService;

@RestController
@RequestMapping("/services")
public class UserController {

	@Autowired
	private MeasureService measureService;

	@RequestMapping("/home")
	String home() {
		return "Hello World!";
	}

	@GetMapping(path = "/findAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> usersList() {
		Response response = new Response();
		try {
			List<User> usuarios = measureService.findAllUsers();
			if (usuarios.isEmpty()) {
				response.setStatus(204);
				return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
			}
			for (User user : usuarios) {
				System.out.println(user.toString());
			}
			response.setStatus(200);
			response.setData(usuarios);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getUserName());

		List<User> users = measureService.findUserByUserName(user.getUserName());
		if (users != null && !users.isEmpty()) {
			System.out.println("A User with name " + user.getUserName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		measureService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user/{name:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("name") String name) {
		System.out.println("Fetching User with username " + name);
		List<User> users = measureService.findUserByUserName(name);
		if (users.isEmpty()) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(users.get(0), HttpStatus.OK);
	}
}
