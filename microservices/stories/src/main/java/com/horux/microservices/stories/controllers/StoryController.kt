package com.horux.microservices.stories.controllers

import com.horux.common.controllers.CrudController
import com.horux.common.mappers.IListResponseMapper
import com.horux.common.mappers.IRequestMapper
import com.horux.common.mappers.IResponseMapper
import com.horux.microservices.entities.StoryDao
import com.horux.microservices.stories.mappers.StoryListResponseMapper
import com.horux.microservices.stories.mappers.StoryRequestMapper
import com.horux.microservices.stories.mappers.StoryResponseMapper
import com.horux.microservices.stories.services.StoryService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/v1/stories")
class StoryController(
    override val service: StoryService,
    override val requestMapper: StoryRequestMapper,
    override val responseMapper: StoryResponseMapper,
    override val listResponseMapper: StoryListResponseMapper
): CrudController<Any,Any, StoryDao, UUID,StoryService> {

}