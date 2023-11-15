package com.horux.microservices.profiles.mappers

import com.horux.common.mappers.IListResponseMapper
import com.horux.microservices.entities.ProfileDao
import com.horux.microservices.profiles.models.response.ProfileResponse
import org.springframework.stereotype.Component

@Component
class ProfileListResponseMapper(val mapper: ProfileResponseMapper): IListResponseMapper<ProfileDao,ProfileResponse> {
    override fun dataToResponse(data: List<ProfileDao>): List<ProfileResponse> = data.map {
        mapper.dataToResponse(it)
    }

}