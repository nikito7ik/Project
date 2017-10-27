package com.project.nikita.kovalev.service;

import com.project.nikita.kovalev.entity.Volunteer;
import com.project.nikita.kovalev.entity.enums.Organization;
import com.project.nikita.kovalev.entity.enums.Sex;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public interface VolunteerService {

    List<Volunteer> getAll();
    Volunteer getByID(long id);
    Volunteer save(Volunteer volunteer);
    void remove(long id);
    void createVolunteer(long id, String name, int age, Sex sex,
                         String phoneNumber, Organization organization) throws ServiceException;
}
