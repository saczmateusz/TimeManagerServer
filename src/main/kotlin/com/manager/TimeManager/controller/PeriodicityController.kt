package com.manager.TimeManager.controller

import com.manager.TimeManager.model.Periodicity
import com.manager.TimeManager.repository.PeriodicityRepository
import com.manager.TimeManager.repository.TaskRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/task/{taskId}/periodicity")
class PeriodicityController(val periodicityRepository: PeriodicityRepository, val taskRepository: TaskRepository) {

    @PostMapping
    fun create(@Valid @RequestBody periodicity: Periodicity, @PathVariable taskId: Int) : ResponseEntity<Any> {

        val task = taskRepository.findById(taskId).orElse(null)

        if(task.periodicity != null)
            return ResponseEntity("Task already has a periodicity", HttpStatus.BAD_REQUEST)

        periodicity.task = task

        return ResponseEntity(periodicityRepository.save(periodicity), HttpStatus.OK)
    }

    @DeleteMapping
    fun delete(@RequestBody periodicity: Periodicity) : Boolean {
        periodicityRepository.delete(periodicity)
        return true
    }

}