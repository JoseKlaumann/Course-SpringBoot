package com.joseklaumann.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joseklaumann.course.entities.User;
import com.joseklaumann.course.services.UserService;

// Controlador Rest que responde no caminho 'users'\

// Resource Layer (rest controllers)
@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	// Service Layer
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		
		// ResponseEntity.ok() = Devolve a resposta http
		return ResponseEntity.ok().body(list);
	}
	
	// Requisicao do tipo get
	// E por eu passar na url o valor do id, e pra mim falar que a url vai ter um parametro
	// eu vou ter que criar esse value
	// Para poder receber o parametro dentro do endpoint do controlador rest
	// eu tenho que declarar um argumento (id) e pro spring aceitar o id e considerar como parametro que vai chegar na url
	// preciso colocar o anotation @PathVariable
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
