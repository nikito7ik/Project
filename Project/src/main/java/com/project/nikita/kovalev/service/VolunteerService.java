package com.project.nikita.kovalev.service;

import com.project.nikita.kovalev.entity.Volunteer;

import java.util.List;

public interface VolunteerService {

    List<Volunteer> getAll();
    Volunteer getByID(long id);
    Volunteer save(Volunteer volunteer);
    void remove(long id);
}
