package com.manager.TimeManager.repository

import com.manager.TimeManager.model.Notification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface NotificationRepository : JpaRepository<Notification, Int>, JpaSpecificationExecutor<Notification>