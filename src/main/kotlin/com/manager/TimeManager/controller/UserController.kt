package com.manager.TimeManager.controller

import com.manager.TimeManager.facade.AuthFacade
import com.manager.TimeManager.model.AppUser
import com.manager.TimeManager.service.AppUserService
import org.springframework.web.bind.annotation.*
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.transaction.annotation.Transactional


@RestController
@RequestMapping("/api/user")
@Transactional
class UserController(val appUserService: AppUserService)
{
    @GetMapping
    fun getUser() : AppUser? {
        /* idk about this and authfacade.user() xD */
        return appUserService.findUserByUsername(AuthFacade.user().username)
    }
}