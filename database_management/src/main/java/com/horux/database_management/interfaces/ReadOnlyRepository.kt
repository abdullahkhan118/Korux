package com.horux.database_management.interfaces

import org.springframework.data.repository.Repository

interface ReadOnlyRepository<T,ID>: Repository<T,ID>