package com.manager.TimeManager.dao

import com.manager.TimeManager.model.AppUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface AppUserDAO : JpaRepository<AppUser, Int>, JpaSpecificationExecutor<AppUser> {
    fun findByUsername(username: String) : AppUser?
}