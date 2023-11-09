package com.horux.common.repository

import com.horux.common.models.daos.CommonModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.util.*

@NoRepositoryBean
interface CrudRepository<T: CommonModel>: JpaRepository<T, UUID> {

}