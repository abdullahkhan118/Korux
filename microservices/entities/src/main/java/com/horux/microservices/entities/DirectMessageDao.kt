package com.horux.microservices.entities

import com.horux.common.models.daos.CommonModel
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.*

@Entity
data class DirectMessageDao(
    @Id
    @GeneratedValue
    override val id: UUID = UUID.randomUUID(),

    @ManyToOne
    val sender: ProfileDao,

    @ManyToOne
    val receiver: ProfileDao,

    val message: String,
    val datetimeSent: Long
): CommonModel<UUID>()

