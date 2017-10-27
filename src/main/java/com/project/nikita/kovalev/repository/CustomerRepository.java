package com.project.nikita.kovalev.repository;

import com.project.nikita.kovalev.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface for Customer
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
