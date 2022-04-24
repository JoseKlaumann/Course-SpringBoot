package com.joseklaumann.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseklaumann.course.entities.Order;
import com.joseklaumann.course.repositories.OrderRepository;

// Registrar a classe como um componente (Component) do spring
// E assim ela vai poder ser injetada automaticamente com o Autowired

// O service serve para a camada de servicos

// Service Layer
@Service
public class OrderService {

	// Data Access Layer (data repositories)
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}	
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		
		return obj.get();
	}
}
