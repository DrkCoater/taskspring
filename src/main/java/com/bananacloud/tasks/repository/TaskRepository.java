package com.bananacloud.tasks.repository;

import com.bananacloud.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {


}
