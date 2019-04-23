package com.manager.TimeManager.facade

import com.manager.TimeManager.model.AppUser
import org.springframework.security.core.context.SecurityContextHolder

class AuthFacade() {
    companion object {
        fun user() : AppUser {
            val auth = SecurityContextHolder.getContext().authentication
            val user = (auth.principal as AppUser)
            return user
        }
    }
}