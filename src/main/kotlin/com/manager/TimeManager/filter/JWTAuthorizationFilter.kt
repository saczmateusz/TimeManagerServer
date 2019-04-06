package com.manager.TimeManager.filter

import com.manager.TimeManager.config.SecurityConstants.Companion.HEADER_STRING
import com.manager.TimeManager.config.SecurityConstants.Companion.SECRET
import com.manager.TimeManager.config.SecurityConstants.Companion.TOKEN_PREFIX
import com.manager.TimeManager.service.CustomUserDetailsService
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthorizationFilter(val authManager: AuthenticationManager, val customUserDetailsService: CustomUserDetailsService)
    : BasicAuthenticationFilter(authManager)
{
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val header = request.getHeader(HEADER_STRING)

        if(header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response)
            return
        }

        val usernamePasswordAuth = getAuthenticationToken(request)
        SecurityContextHolder.getContext().authentication = usernamePasswordAuth
        chain.doFilter(request, response)
    }

    fun getAuthenticationToken(request: HttpServletRequest) : UsernamePasswordAuthenticationToken? {
        val token = request.getHeader(HEADER_STRING).replace(TOKEN_PREFIX, "")

        try {
            val username = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .body
                    .subject

            val userDetails = customUserDetailsService.loadUserByUsername(username)
            val appUser = customUserDetailsService.loadAppUserByUsername(username)

            return UsernamePasswordAuthenticationToken(appUser, null, userDetails.authorities)
        }
        catch(e: Exception) {
            return null
        }



    }
}