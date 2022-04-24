package com.joseklaumann.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseklaumann.course.entities.Order;

// Aqui nao e necessario colocar o @Repository porque 
// ela ja esta extendendo um repository que ja e registrado\
// como um componente do spring

//Data Access Layer (data repositories)
public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
