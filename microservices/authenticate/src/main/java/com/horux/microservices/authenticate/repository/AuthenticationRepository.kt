package com.horux.microservices.authenticate.repository

import com.horux.authentication.jwt.repositories.JwtAuthenticateUserRepository
import com.horux.microservices.authenticate.models.AuthenticatedUser
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AuthenticationRepository: JwtAuthenticateUserRepository<AuthenticatedUser, UUID>