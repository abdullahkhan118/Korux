package com.horux.microservices.entities

import com.horux.common.models.daos.CommonModel
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*


@Entity
data class HashtagDao(
    @Id
    @GeneratedValue
    override val id: UUID = UUID.randomUUID(),

    @Column(unique = true)
    val hashtag: String
): CommonModel<UUID>()
