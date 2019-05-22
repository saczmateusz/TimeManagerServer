package com.manager.TimeManager.controller

import com.manager.TimeManager.facade.AuthFacade
import com.manager.TimeManager.model.AppUser
import com.manager.TimeManager.repository.AppUserRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/user")
class UserController(val appUserRepository: AppUserRepository)
{
    @GetMapping
    fun index() : AppUser? {
        val user = appUserRepository.findByUsername(AuthFacade.user().username.orEmpty())
        user?.tasks = user?.tasks?.sortedWith(compareByDescending { it.priority })
        return user
    }
}