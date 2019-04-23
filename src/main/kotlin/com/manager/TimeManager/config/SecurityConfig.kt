package com.manager.TimeManager.config


import com.manager.TimeManager.filter.JWTAuthorizationFilter
import com.manager.TimeManager.service.CustomUserDetailsService
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig(val customUserDetailsService: CustomUserDetailsService) : WebSecurityConfigurerAdapter()  {
    @Override
    override fun configure(security: HttpSecurity) {
        security.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/api/**").hasRole("USER")
                .and()
                .addFilter(JWTAuthorizationFilter(authenticationManager(), customUserDetailsService))
    }
}