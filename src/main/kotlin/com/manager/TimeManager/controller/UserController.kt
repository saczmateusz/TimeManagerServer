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
        /* the user object saved in AuthFacade doesn't have eager loaded tasks, so we need to query the DB again */
        return appUserRepository.findByUsername(AuthFacade.user().username)
    }
}