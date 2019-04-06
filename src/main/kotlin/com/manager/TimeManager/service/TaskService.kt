package com.manager.TimeManager.service

import com.manager.TimeManager.dao.TaskDAO
import com.manager.TimeManager.model.Task
import org.hibernate.Criteria
import org.springframework.stereotype.Repository
import javax.persistence.criteria.CriteriaBuilder

@Repository
class TaskService(val dao: TaskDAO) {

    fun insertTask(task: Task): Task {
        return dao.save(task)
    }

    fun deleteTask(task: Task): Unit {
        return dao.delete(task)
    }

}