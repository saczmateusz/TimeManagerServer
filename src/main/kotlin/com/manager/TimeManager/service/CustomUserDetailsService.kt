package com.manager.TimeManager.service

import com.manager.TimeManager.model.AppUser
import com.manager.TimeManager.repository.AppUserRepository
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(val appUserRepository: AppUserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val appUser = loadAppUserByUsername(username)
        return User(appUser?.username, appUser?.password, AuthorityUtils.createAuthorityList("ROLE_USER"))
    }

    fun loadAppUserByUsername(username: String) : AppUser? {
        return appUserRepository.findByUsername(username)
    }

}
