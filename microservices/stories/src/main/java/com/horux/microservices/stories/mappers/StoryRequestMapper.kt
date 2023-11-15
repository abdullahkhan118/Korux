package com.horux.microservices.stories.mappers

import com.horux.common.mappers.IRequestMapper
import com.horux.microservices.stories.models.daos.StoryDao
import org.springframework.stereotype.Component
import java.util.*

@Component
class StoryRequestMapper: IRequestMapper<Any,StoryDao> {
    override fun requestToData(request: Any): StoryDao = StoryDao(
        UUID.randomUUID(),System.currentTimeMillis(),"",""
    )
}