package com.horux.logging.models.daos

import com.horux.logging.models.enums.DatabaseAction
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.sql.Timestamp
import java.util.*

@Entity
data class LogDatabaseActionDao(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,
    val action: DatabaseAction,
    val timestamp: Timestamp,
    val loggedData: Any
)
