package com.horux.microservices.profiles.mappers

import com.horux.common.mappers.IResponseMapper
import com.horux.microservices.entities.ProfileDao
import com.horux.microservices.profiles.models.response.ProfileResponse
import org.springframework.stereotype.Component

@Component
class ProfileResponseMapper: IResponseMapper<ProfileDao,ProfileResponse> {
    override fun dataToResponse(data: ProfileDao): ProfileResponse = with(data) {
        ProfileResponse(
            id, username, bio, profilePicture , email, password
        )
    }

}