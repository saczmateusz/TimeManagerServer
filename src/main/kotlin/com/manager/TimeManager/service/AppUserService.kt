package com.manager.TimeManager.service

import com.manager.TimeManager.dao.AppUserDAO
import com.manager.TimeManager.model.AppUser
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository

@Repository
class AppUserService(val dao: AppUserDAO, val passwordEncoder: PasswordEncoder)
{
    fun insertUser(appUser: AppUser) : AppUser? {
        appUser.password = passwordEncoder.encode(appUser.password)
        return dao.save(appUser)
    }

    fun findUserByUsername(username: String) : AppUser? {
        return dao.findByUsername(username)
    }
}