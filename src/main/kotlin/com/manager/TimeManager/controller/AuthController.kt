package com.manager.TimeManager.controller

import com.manager.TimeManager.model.AppUser
import com.manager.TimeManager.repository.AppUserRepository
import com.manager.TimeManager.service.AuthService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
class AuthController(val authService: AuthService, val appUserRepository: AppUserRepository) {

    @PostMapping("/auth/login")
    fun login(@RequestBody input: Map<String, String?>) : ResponseEntity<HashMap<String, String>> {
        val user = authService.attemptLogin(input["username"], input["password"])

        user ?: return ResponseEntity(hashMapOf("error" to "Bad credentials"), HttpStatus.UNAUTHORIZED)

        val token = authService.makeTokenForUser(user)
        return ResponseEntity(hashMapOf("token" to token), HttpStatus.OK)
    }

    @PostMapping("/auth/register")
    fun register(@Valid @RequestBody newUser : AppUser) : ResponseEntity<Any> {
        val user: AppUser?

        try {
            newUser.password = BCryptPasswordEncoder().encode(newUser.password)
            user = appUserRepository.save(newUser)
        }
        catch (e: Exception) {
            return ResponseEntity(e.message, HttpStatus.FORBIDDEN)
        }

        return ResponseEntity(user, HttpStatus.OK)

    }
}