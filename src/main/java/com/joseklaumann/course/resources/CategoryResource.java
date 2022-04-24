package com.joseklaumann.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseklaumann.course.entities.Category;
import com.joseklaumann.course.services.CategoryService;

// Controlador Rest que responde no caminho 'users'\

// Resource Layer (rest controllers)
@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	// Service Layer
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		
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
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
