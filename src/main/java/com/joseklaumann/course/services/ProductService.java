package com.joseklaumann.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseklaumann.course.entities.Product;
import com.joseklaumann.course.repositories.ProductRepository;

// Registrar a classe como um componente (Component) do spring
// E assim ela vai poder ser injetada automaticamente com o Autowired

// O service serve para a camada de servicos

// Service Layer
@Service
public class ProductService {

	// Data Access Layer (data repositories)
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}	
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		
		return obj.get();
	}
}
