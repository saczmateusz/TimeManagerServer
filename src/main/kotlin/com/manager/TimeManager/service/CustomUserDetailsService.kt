package com.manager.TimeManager.service

import com.manager.TimeManager.model.AppUser
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(val appUserService: AppUserService) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val appUser = loadAppUserByUsername(username)
        return User(appUser?.username, appUser?.password, AuthorityUtils.createAuthorityList("ROLE_USER"))
    }

    fun loadAppUserByUsername(username: String) : AppUser? {
        return appUserService.findUserByUsername(username)
    }

}