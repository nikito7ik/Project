package com.project.nikita.kovalev.repository;

import com.project.nikita.kovalev.entity.VolunteerTask;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface for VolunteerTask
public interface VolunteerTaskRepository extends JpaRepository<VolunteerTask, Long> {
}
