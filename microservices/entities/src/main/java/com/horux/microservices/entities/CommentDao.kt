package com.horux.microservices.entities

import com.horux.common.models.daos.CommonModel
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.*


@Entity
data class CommentDao(
    @Id
    @GeneratedValue
    override val id: UUID = UUID.randomUUID(),

    @ManyToOne
    val profile: ProfileDao,

    @ManyToOne
    val post: PostDao,

    val datetimeAdded: Long,
    val comment: String
): CommonModel<UUID>()
