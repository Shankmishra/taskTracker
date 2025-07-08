package com.Task.Tracker.service;

import com.Task.Tracker.dto.TaskRequest;
import com.Task.Tracker.model.Status;
import com.Task.Tracker.model.Task;
import com.Task.Tracker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TrackerService {

    @Autowired
    private TaskRepository trepo;

    public void createTaskService(TaskRequest tr){
        Task t =new  Task();
        t.setCreatedBy(tr.getCreatedBy());
        t.setAssignedTo(tr.getAssignedTo());
        t.setTitle(tr.getTitile());
        t.setDescription(tr.getDescription());
        t.setDate(LocalDate.now());
        t.setTime(LocalTime.now());
        t.setStatus(Status.OPEN);
        trepo.save(t);

    }

    public List<Task> showTaskService(){
         return trepo.findAll();

    }
    public List<Task> showTaskServiceByStatus(Status status){
        return trepo.findByStatus(status);

    }
    public List<Task> showTaskServiceByFilter(Status status, String createdBy, String assignedTo) {
        if (status != null && createdBy != null && assignedTo != null) {
            return trepo.findByStatusAndCreatedByAndAssignedTo(status, createdBy, assignedTo);
        } else if (status != null && createdBy != null) {
            return trepo.findByStatusAndCreatedBy(status, createdBy);
        } else if (status != null && assignedTo != null) {
            return trepo.findByStatusAndAssignedTo(status, assignedTo);
        } else if (createdBy != null && assignedTo != null) {
            return trepo.findByCreatedByAndAssignedTo(createdBy, assignedTo);
        } else if (status != null) {
            return trepo.findByStatus(status);
        } else if (createdBy != null) {
            return trepo.findByCreatedBy(createdBy);
        } else if (assignedTo != null) {
            return trepo.findByAssignedTo(assignedTo);
        } else {
            return trepo.findAll();
        }
    }


}
