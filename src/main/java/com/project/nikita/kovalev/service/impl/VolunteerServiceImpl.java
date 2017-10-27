package com.project.nikita.kovalev.service.impl;

import com.project.nikita.kovalev.entity.Customer;
import com.project.nikita.kovalev.entity.Volunteer;
import com.project.nikita.kovalev.entity.enums.CustomerCategory;
import com.project.nikita.kovalev.repository.VolunteerRepository;
import com.project.nikita.kovalev.service.VolunteerService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    private VolunteerRepository repository;

    @Override
    public List<Volunteer> getAll() {
        return repository.findAll();
    }

    @Override
    public Volunteer getByID(long id) {
        return repository.findOne(id);
    }

    @Override
    public Volunteer save(Volunteer volunteer) {
        return repository.saveAndFlush(volunteer);
    }

    @Override
    public void remove(long id) {
        repository.delete(id);
    }

    @Override
    public void createVolunteer(long id, String name, int age, String phoneNumber) throws ServiceException {
        Volunteer volunteer = new Volunteer();
        volunteer.setId(id);
        volunteer.setName(name);
        volunteer.setAge(age);
        volunteer.setPhoneNumber(phoneNumber);
        save(volunteer);
    }
}
