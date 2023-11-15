package com.horux.microservices.stories.mappers

import com.horux.common.mappers.IListResponseMapper
import com.horux.microservices.stories.models.daos.StoryDao
import org.springframework.stereotype.Component

@Component
class StoryListResponseMapper(val responseMapper: StoryResponseMapper): IListResponseMapper<StoryDao,Any> {
    override fun dataToResponse(data: List<StoryDao>): List<Any> = data.map {
        responseMapper.dataToResponse(it)
    }
}