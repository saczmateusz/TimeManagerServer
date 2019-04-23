package com.manager.TimeManager.controller

import com.manager.TimeManager.model.Notification
import com.manager.TimeManager.model.Task
import com.manager.TimeManager.repository.NotificationRepository
import com.manager.TimeManager.repository.TaskRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/task/{taskId}/notification")
class NotificationController(val notificationRepository: NotificationRepository, val taskRepository: TaskRepository) {

    @PostMapping
    fun create(@Valid @RequestBody notification: Notification, @PathVariable taskId: Int) : ResponseEntity<Any> {

        val task = taskRepository.findById(taskId).orElse(null)

        if(task.notification != null)
            return ResponseEntity("Task already has a notification", HttpStatus.BAD_REQUEST)

        notification.task = task

        return ResponseEntity(notificationRepository.save(notification), HttpStatus.OK)
    }

    @DeleteMapping
    fun delete(@RequestBody notification: Notification) : Boolean {
        notificationRepository.delete(notification)
        return true
    }

    /*
    @PutMapping
    fun update(@RequestBody notification: Notification) : Notification {
        return notificationRepository.save(notification)
    }
    */
}
