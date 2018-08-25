package com.bananacloud.tasks;

import com.bananacloud.tasks.domain.Task;
import com.bananacloud.tasks.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class TasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasksApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(TaskService taskService) {
        return args -> {
            taskService.save( new Task(1L,"Create controllers", LocalDate.now(), false) );
            taskService.save( new Task(2L,"Create models", LocalDate.now().plus(3, ChronoUnit.DAYS), true) );
            taskService.save( new Task(3L,"Create services", LocalDate.now().plus(4, ChronoUnit.DAYS), true) );
        };
    }
}
