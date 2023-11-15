package com.horux.microservices.stories.mappers

import com.horux.common.mappers.IResponseMapper
import com.horux.microservices.entities.StoryDao
import org.springframework.stereotype.Component

@Component
class StoryResponseMapper : IResponseMapper<StoryDao, Any> {
    override fun dataToResponse(data: StoryDao): Any = Any()
}