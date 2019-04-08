package com.manager.TimeManager.controller

import com.manager.TimeManager.model.Notification
import com.manager.TimeManager.repository.NotificationRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*

@RestController
class NotificationController(val notificationRepository: NotificationRepository) {

    @PostMapping
    fun create(@ModelAttribute notification: Notification) : Notification {
        return notificationRepository.save(notification)
    }

    @DeleteMapping
    fun delete(@ModelAttribute notification: Notification) : Boolean {
        notificationRepository.delete(notification)
        return true
    }

    @PutMapping
    fun update(@ModelAttribute notification: Notification) : Notification {
        return notificationRepository.save(notification)
    }
}