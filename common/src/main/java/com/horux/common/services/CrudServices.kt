package com.horux.common.services

import com.horux.common.exceptions.AlreadyExistsException
import com.horux.common.exceptions.CollectionEmptyException
import com.horux.common.exceptions.NotFoundException
import com.horux.common.helper.ServiceHelper
import com.horux.common.models.daos.CommonModel
import com.horux.common.repository.CrudRepository
import java.util.*

interface CrudServices<T : CommonModel> : ServiceHelper<T> {
    val repository: CrudRepository<T>
    fun create(data: T): T = with(repository.findById(data.id)) {
        if (isEmpty) repository.save(data)
        else throw AlreadyExistsException()
    }

    fun getById(id: UUID): T = with(repository.findById(id)) {
        if (isEmpty) throw NotFoundException()
        else this.get()
    }

    fun getAll(): List<T> = with(repository.findAll()) {
        if (isEmpty()) throw CollectionEmptyException()
        else this
    }

    fun update(data: T): T = with(repository.findById(data.id)) {
        if (exists(this)) {
            repository.save(data)
        } else {
            throw NotFoundException()
        }
    }

    fun updateAll(data: List<T>): List<T> = data.map {
        update(it)
    }

    fun delete(data: T): T = deleteById(data.id)

    fun deleteAll(data: List<T>): List<T> = data.map {
        delete(it)
    }

    fun deleteById(id: UUID): T = with(repository.findById(id)) {
        if (exists(this)) {
            repository.deleteById(id)
            get()
        } else {
            throw NotFoundException()
        }
    }

    fun deleteAllById(ids: List<UUID>): List<T> = ids.map {
        deleteById(it)
    }

}