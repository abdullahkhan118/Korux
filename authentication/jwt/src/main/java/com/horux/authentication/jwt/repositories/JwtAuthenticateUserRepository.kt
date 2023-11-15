package com.horux.authentication.jwt.repositories

import com.horux.authentication.jwt.models.JwtAuthenticatedUser
import com.horux.authentication.models.AuthenticatedUser
import com.horux.authentication.repositories.AuthenticateUserRepository
import org.springframework.stereotype.Repository
import java.util.Optional

interface JwtAuthenticateUserRepository<T : JwtAuthenticatedUser<ID>, ID> : AuthenticateUserRepository<T, ID>