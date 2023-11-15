package com.horux.microservices.entities

import com.horux.common.models.daos.CommonModel
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.UUID

@Entity
data class ProfileDao(
    @Id
    @GeneratedValue
    override val id: UUID = UUID.randomUUID(),

    val username: String,
    val email: String,
    val password: String,
    val bio: String,
    val profilePicture: String
) : CommonModel<UUID>()

