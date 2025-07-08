package com.Task.Tracker.controller;

import com.Task.Tracker.dto.TaskRequest;
import com.Task.Tracker.model.Status;
import com.Task.Tracker.model.Task;
import com.Task.Tracker.service.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/root/task")
public class TrackerController {

    @Autowired
    private TrackerService trackerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void CreateTask(@RequestBody TaskRequest tr){
        trackerService.createTaskService(tr);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Task> showTasks(){
        return trackerService.showTaskService();
    }

    @GetMapping("/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    private List<Task> showTasksbyStatus(@PathVariable Status status){
        return trackerService.showTaskServiceByStatus(status);
    }

    @GetMapping("/FilterBy")
    @ResponseStatus(HttpStatus.OK)
    private List<Task> showTasksbyFilter(@RequestParam(required = false) Status status,@RequestParam(required = false) String createdBy,@RequestParam(required = false) String assignedTo){
        return trackerService.showTaskServiceByFilter(status,createdBy,assignedTo);
    }


}
