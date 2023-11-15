package com.horux.logging.models.services

import com.horux.logging.models.daos.LogDatabaseActionDao
import com.horux.logging.models.repository.LogDatabaseActionRepository
import org.springframework.stereotype.Service

@Service
class LogDatabaseActionService(val repository: LogDatabaseActionRepository) {

    fun addLog(data: LogDatabaseActionDao) = repository.save(data)

}