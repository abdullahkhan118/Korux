package com.horux.database_management.interfaces.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface ReadOnlyRepository<T,ID>: JpaRepository<T,ID>, JpaSpecificationExecutor<T>