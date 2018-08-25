package com.bananacloud.tasks.service;

import com.bananacloud.tasks.domain.Task;

public interface TaskService {
    Iterable<Task> list();

    Task save(Task task);

    void delete(Task task);
}
