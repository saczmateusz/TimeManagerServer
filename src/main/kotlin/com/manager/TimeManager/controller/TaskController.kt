package com.manager.TimeManager.controller

import com.manager.TimeManager.facade.AuthFacade
import com.manager.TimeManager.model.Task
import com.manager.TimeManager.service.TaskService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/tasks")
class TaskController(val taskService: TaskService) {

    @GetMapping
    fun index() : List<Task>? {
        return AuthFacade.user().tasks
    }

}