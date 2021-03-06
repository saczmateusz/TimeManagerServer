package com.manager.TimeManager.controller

import com.manager.TimeManager.facade.AuthFacade
import com.manager.TimeManager.model.Task
import com.manager.TimeManager.repository.TaskRepository
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/tasks")
class TaskController(val taskRepository: TaskRepository) {

    @GetMapping
    fun index() : List<Task>? {
        return taskRepository.findByUserId(AuthFacade.user().id)
    }

    @PostMapping
    fun create(@Valid @RequestBody task: Task) : Task? {
        task.user = AuthFacade.user()
        return taskRepository.save(task)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int) : Boolean {
        val task: Task? = taskRepository.findById(id).orElse(null)

        if(task == null || task.user?.id != AuthFacade.user().id)
            return false

        taskRepository.delete(task)
        return true
    }

    @PostMapping("{id}/archive")
    fun archive(@PathVariable id: Int) : Boolean {
        val task: Task? = taskRepository.findById(id).orElse(null)

        if(task == null || task.user?.id != AuthFacade.user().id)
            return false

        task.isArchived = true
        taskRepository.save(task)
        return true

    }

    /*
    @PutMapping("{id}")
    fun update(@RequestBody task: Task) : Task? {
        return taskRepository.save(task)
    }
    */

}