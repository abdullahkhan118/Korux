package com.horux.microservices.authenticate.services

import com.horux.authentication.jwt.repositories.JwtAuthenticateUserRepository
import com.horux.authentication.jwt.services.JwtService
import com.horux.microservices.authenticate.models.AuthenticatedUser
import com.horux.microservices.authenticate.repository.AuthenticationRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AuthenticationService(
                            override val userDetailsService: UserDetailsService,
                            override val repository: AuthenticationRepository
): JwtService<AuthenticatedUser,UUID,AuthenticationRepository> {
    override val secretKey: String = ""
    fun registerUser(authenticatedUser: AuthenticatedUser) = repository.save(authenticatedUser)

}