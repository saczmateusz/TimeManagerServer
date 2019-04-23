package com.manager.TimeManager.repository

import com.manager.TimeManager.model.Periodicity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface PeriodicityRepository : JpaRepository<Periodicity, Int>, JpaSpecificationExecutor<Periodicity>