package pe.com.mediciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.mediciones.bean.Respuesta;
import pe.com.monitoreo.entity.Usuario;
import pe.com.monitoreo.service.MonitoreoService;

@RestController
@RequestMapping("/services")
public class UsuarioController {

	@Autowired
	private MonitoreoService monitoreoService;
	
	@RequestMapping("/home")
	String home() {
		return "Hello World!";
	}
	
	@GetMapping(path = "/listadoUsuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Respuesta> userList() {		
		Respuesta respuesta = new Respuesta();
		try {
			List<Usuario> usuarios = monitoreoService.listarUsuarios();
			if (usuarios.isEmpty()) {
				respuesta.setStatus(204);
				return new ResponseEntity<Respuesta>(respuesta, HttpStatus.NO_CONTENT);
			}
			for (Usuario user : usuarios) {
				System.out.println(user.toString());
			}
			respuesta.setStatus(200);
			respuesta.setData(usuarios);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}
}
