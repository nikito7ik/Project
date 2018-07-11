package com.project.nikita.kovalev.service;

import com.project.nikita.kovalev.entity.VolunteerTask;
import com.project.nikita.kovalev.entity.enums.Status;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public interface VolunteerTaskService {

    List<VolunteerTask> getAll();
    VolunteerTask getByID(long id);
    VolunteerTask save(VolunteerTask volunteerTask);
    void remove(long id);
    void createVolunteerTask(long id, String title, String description, String taskDate,
                             String address, boolean car, Status status) throws ServiceException;

}
