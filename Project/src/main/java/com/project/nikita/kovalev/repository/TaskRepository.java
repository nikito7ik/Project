package com.project.nikita.kovalev.repository;

import com.project.nikita.kovalev.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
