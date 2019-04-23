package com.manager.TimeManager.repository

import com.manager.TimeManager.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : JpaRepository<Task, Int>, JpaSpecificationExecutor<Task> {
    fun findByUserId(userId: Int?) : List<Task>
    fun findById(id: Int?) : Task?
}