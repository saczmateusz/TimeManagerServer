package com.manager.TimeManager.controller

import com.manager.TimeManager.facade.AuthFacade
import com.manager.TimeManager.model.Task
import com.manager.TimeManager.repository.TaskRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/tasks")
class TaskController(val taskRepository: TaskRepository) {

    @GetMapping
    fun index() : List<Task>? {
        return taskRepository.findByUserId(AuthFacade.user().id)
    }

    @PostMapping
    fun create(@ModelAttribute task: Task) : Task? {
        return taskRepository.save(task)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int) : Boolean {
        val task: Task? = taskRepository.findById(id).orElse(null)

        if(task == null || task.user != AuthFacade.user())
            return false

        taskRepository.delete(task)
        return true
    }

    @PutMapping
    fun update(@ModelAttribute task: Task) : Task? {
        return taskRepository.save(task)
    }

}