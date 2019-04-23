package com.manager.TimeManager.repository

import com.manager.TimeManager.model.AppUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface AppUserRepository : JpaRepository<AppUser, Int>, JpaSpecificationExecutor<AppUser> {
    fun findByUsername(username: String) : AppUser?
}