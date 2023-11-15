package com.horux.microservices.profiles.mappers

import com.horux.common.mappers.IRequestMapper
import com.horux.microservices.entities.ProfileDao
import com.horux.microservices.profiles.models.request.ProfileRequest
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProfileRequestMapper : IRequestMapper<ProfileRequest, ProfileDao> {
    override fun requestToData(request: ProfileRequest): ProfileDao = with(request) {
        ProfileDao(
            UUID.randomUUID(), name,
            bio, photo, emailAddress, password
        )
    }
}