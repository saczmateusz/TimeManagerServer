package com.manager.TimeManager.service

import com.manager.TimeManager.config.SecurityConstants
import com.manager.TimeManager.dao.AppUserDAO
import com.manager.TimeManager.model.AppUser
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.AbstractPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit
import java.util.*

@Service
class AuthService(val appUserDAO: AppUserDAO, val passwordEncoder: PasswordEncoder) {

    fun attemptLogin(username: String?, password: String?) : AppUser? {
        if(username == null || password == null) return null

        val user = appUserDAO.findByUsername(username)
        if(user == null || !passwordEncoder.matches(password, user.password)) return null

        return user
    }

    fun makeTokenForUser(user: AppUser) : String {
        val expirationTime = ZonedDateTime.now(ZoneOffset.UTC)
                .plus(SecurityConstants.EXPIRATION_TIME, ChronoUnit.MILLIS)

        return Jwts.builder()
                .setSubject(user.username)
                .setExpiration(Date.from(expirationTime.toInstant()))
                .signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
                .compact()
    }

}