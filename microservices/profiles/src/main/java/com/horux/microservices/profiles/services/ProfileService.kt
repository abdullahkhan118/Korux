package com.horux.microservices.profiles.services

import com.horux.common.services.CrudServices
import com.horux.microservices.entities.ProfileDao
import com.horux.microservices.profiles.repository.ProfileRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ProfileService(override val repository: ProfileRepository): CrudServices<ProfileDao,UUID>