package com.horux.users.repository

import com.horux.database_management.interfaces.ReadOnlyRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: ReadOnlyRepository<Any, UUID>