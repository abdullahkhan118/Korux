package com.horux.microservices.authenticate.config

import com.horux.authentication.jwt.config.JwtApplicationConfig
import com.horux.authentication.jwt.repositories.JwtAuthenticateUserRepository
import com.horux.authentication.jwt.requestInterceptor.JwtAuthenticationInterceptor
import com.horux.authentication.jwt.tokens.JwtAuthentication
import com.horux.authentication.repositories.AuthenticateUserRepository
import com.horux.authentication.tokens.Authentication
import com.horux.microservices.authenticate.models.AuthenticatedUser
import com.horux.microservices.authenticate.repository.AuthenticationRepository
import com.horux.microservices.authenticate.services.AuthenticationService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.util.*

@Configuration
class ApplicationConfig(override val authenticateUserRepository: AuthenticationRepository) :
    JwtApplicationConfig<AuthenticatedUser, UUID, AuthenticationService, AuthenticationRepository> {
    @Bean
    override fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    override fun jwtAuthentication(authService: AuthenticationService) = Authentication(authService)

    @Bean
    override fun jwtAuthenticationInterceptor(authentication: JwtAuthentication<AuthenticatedUser, UUID>) =
        AuthenticationInterceptor(authentication)

}

@JvmInline
value class Authentication(override val authService: AuthenticationService) : JwtAuthentication<AuthenticatedUser, UUID>

@JvmInline
value class AuthenticationInterceptor(override val authentication: Authentication<AuthenticatedUser, UUID>) :
    JwtAuthenticationInterceptor<AuthenticatedUser, UUID>
