package com.project.nikita.kovalev.repository;

import com.project.nikita.kovalev.entity.CustomerTask;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface for CustomerTask
public interface CustomerTaskRepository extends JpaRepository<CustomerTask, Long> {
}
