package com.manager.TimeManager.controller

import com.manager.TimeManager.model.AppUser
import com.manager.TimeManager.service.AppUserService
import com.manager.TimeManager.service.AuthService
import jdk.incubator.http.HttpResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class AuthController(val authService: AuthService, val appUserService: AppUserService) {

    @PostMapping("/auth/login")
    fun login(@RequestParam username: String?, @RequestParam password: String?) : ResponseEntity<HashMap<String, String>> {
        val user = authService.attemptLogin(username, password)

        user ?: return ResponseEntity(hashMapOf("error" to "Bad credentials"), HttpStatus.UNAUTHORIZED)

        val token = authService.makeTokenForUser(user)
        return ResponseEntity(hashMapOf("token" to token), HttpStatus.OK)
    }

    @PostMapping("/auth/register")
    fun register(@ModelAttribute newUser : AppUser) : ResponseEntity<Any> {
        val user: AppUser?

        try {
            user = appUserService.insertUser(newUser)
        }
        catch (e: Exception) {
            return ResponseEntity(e.message, HttpStatus.FORBIDDEN)
        }

        return ResponseEntity(user, HttpStatus.OK)

    }
}