package com.Task.Tracker.repository;

import com.Task.Tracker.model.Status;
import com.Task.Tracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,String> {

        List<Task> findByStatus(Status status);

        List<Task> findByCreatedBy(String createdBy);

        List<Task> findByAssignedTo(String assignedTo); // ✅ fixed typo & correct param type

        List<Task> findByStatusAndCreatedBy(Status status, String createdBy);

        List<Task> findByStatusAndAssignedTo(Status status, String assignedTo);

        List<Task> findByCreatedByAndAssignedTo(String createdBy, String assignedTo);

        List<Task> findByStatusAndCreatedByAndAssignedTo(Status status, String createdBy, String assignedTo);
    }

