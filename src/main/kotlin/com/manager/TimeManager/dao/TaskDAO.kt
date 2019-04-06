package com.manager.TimeManager.dao

import com.manager.TimeManager.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface TaskDAO : JpaRepository<Task, Int>, JpaSpecificationExecutor<Task>