package com.horux.microservices.profiles.repository

import com.horux.common.repository.CrudRepository
import com.horux.microservices.entities.ProfileDao
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProfileRepository : CrudRepository<ProfileDao,UUID>