package com.project.nikita.kovalev.repository;

import com.project.nikita.kovalev.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface for Volunteer
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}
