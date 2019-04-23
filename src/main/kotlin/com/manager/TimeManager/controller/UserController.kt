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
        return appUserRepository.findByUsername(AuthFacade.user().username.orEmpty())
    }
}