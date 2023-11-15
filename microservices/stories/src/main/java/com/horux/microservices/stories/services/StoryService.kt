package com.horux.microservices.stories.services

import com.horux.common.services.CrudServices
import com.horux.microservices.entities.StoryDao
import com.horux.microservices.stories.repository.StoryRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class StoryService(override val repository: StoryRepository) : CrudServices<StoryDao, UUID> {
}