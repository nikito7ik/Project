package com.project.nikita.kovalev.service.impl;

import com.project.nikita.kovalev.entity.Volunteer;
import com.project.nikita.kovalev.entity.VolunteerTask;
import com.project.nikita.kovalev.entity.enums.Status;
import com.project.nikita.kovalev.repository.VolunteerTaskRepository;
import com.project.nikita.kovalev.service.VolunteerTaskService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VolunteerTaskServiceImpl implements VolunteerTaskService {

    @Autowired
    private VolunteerTaskRepository repository;

    @Override
    public List<VolunteerTask> getAll() {
        return repository.findAll();
    }

    @Override
    public VolunteerTask getByID(long id) {
        return repository.findOne(id);
    }

    @Override
    public VolunteerTask save(VolunteerTask volunteerTask) {
        return repository.saveAndFlush(volunteerTask);
    }

    @Override
    public void remove(long id) {
        repository.delete(id);
    }

    @Override
    public void createVolunteerTask(long id, String title, String description,
                                    String taskDate, String address, Status status) throws ServiceException {
        VolunteerTask volunteerTask = new VolunteerTask();
        volunteerTask.setId(id);
        volunteerTask.setTitle(title);
        volunteerTask.setDescription(description);
        volunteerTask.setTaskDate(taskDate);
        volunteerTask.setAddress(address);
        volunteerTask.setStatus(status);
        save(volunteerTask);
    }
}
