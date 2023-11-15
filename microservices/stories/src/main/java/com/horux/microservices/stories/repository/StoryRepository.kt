package com.horux.microservices.stories.repository

import com.horux.common.repository.CrudRepository
import com.horux.microservices.entities.StoryDao
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StoryRepository: CrudRepository<StoryDao, UUID>