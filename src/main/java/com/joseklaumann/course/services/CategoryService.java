package com.joseklaumann.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseklaumann.course.entities.Category;
import com.joseklaumann.course.repositories.CategoryRepository;

// Registrar a classe como um componente (Component) do spring
// E assim ela vai poder ser injetada automaticamente com o Autowired

// O service serve para a camada de servicos

// Service Layer
@Service
public class CategoryService {

	// Data Access Layer (data repositories)
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}	
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		
		return obj.get();
	}
}
