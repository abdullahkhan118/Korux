package com.horux.logging.models.repository

import com.horux.logging.models.daos.LogDatabaseActionDao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface LogDatabaseActionRepository: JpaRepository<LogDatabaseActionDao,UUID>