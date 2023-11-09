package com.horux.database_management.interfaces.services

interface CrudService<T,ID> {

    fun getById(): T

    fun getAll(): List<T>

    fun updateById()

    fun updateAll()

    fun create()

    fun delete()
    fun deleteAll()

}