package com.horux.microservices.authenticate.models

import com.horux.authentication.jwt.models.JwtAuthenticatedUser
import com.horux.authentication.models.Role
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.*
import java.util.concurrent.TimeUnit

@Entity
data class AuthenticatedUser(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    override val id: UUID = UUID.randomUUID(),
    override val username: String = "",
    override val password: String = "",
    override val issueAt: Long = System.currentTimeMillis(),
    override val expirationAt: Long = issueAt + TimeUnit.DAYS.toMillis(1),
    override val role : Role = Role.ROLE_USER
): JwtAuthenticatedUser<UUID>(id, username, password, issueAt, expirationAt, role)