package com.bananacloud.tasks.controller;

import com.bananacloud.tasks.domain.Task;
import com.bananacloud.tasks.response.Status;
import com.bananacloud.tasks.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = {"", "/"})
    public Iterable<Task> list() {
        return this.taskService.list();
    }

    @PostMapping("/save")
    public Task saveTask(@RequestBody Task task) {
        return this.taskService.save(task);
    }

    @PostMapping("/delete")
    public ResponseEntity<Status> deleteTask(@RequestBody Task task) {
        this.taskService.delete(task);
        return new ResponseEntity<>(new Status(200, "Success"), HttpStatus.OK);
    }
}
