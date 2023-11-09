package com.horux.common.controllers

import com.horux.common.mappers.IRequestMapper
import com.horux.common.mappers.IListResponseMapper
import com.horux.common.mappers.IResponseMapper
import com.horux.common.models.CommonResponse
import com.horux.common.models.daos.CommonModel
import com.horux.common.services.CrudServices
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import java.util.*

interface CrudController<Rq, Rs, T: CommonModel,S: CrudServices<T>> {

    val service: S

    val requestMapper: IRequestMapper<Rq, T>
    val responseMapper: IResponseMapper<T,Rs>
    val listResponseMapper: IListResponseMapper<T,Rs>

    fun create(body: Rq):  CommonResponse<Rs> = runCatching {
        responseMapper.fromSuccess(service.create(requestMapper.requestToData(body)))
    }.getOrElse {
        responseMapper.fromInvalidBody(it.message!!)
    }

    fun getById(id: String): CommonResponse<Rs> = runCatching {
        responseMapper.fromSuccess(service.getById(UUID.fromString(id)))
    }.getOrElse {
        responseMapper.fromInvalidBody(it.message ?: "Unknown Cause")
    }

    fun getAll(): CommonResponse<List<Rs>> = runCatching {
            listResponseMapper.fromSuccess(service.getAll())
        }.getOrElse {
            listResponseMapper.fromInvalidBody(it.message ?: "Unknown Cause")
        }


    fun update(id: String, @Valid @RequestBody body: Rq):  CommonResponse<Rs> = runCatching {
        responseMapper.fromSuccess(service.update(requestMapper.requestToData(body)))
    }.getOrElse {
        responseMapper.fromInvalidBody(it.message!!)
    }


    fun delete(id: String):  CommonResponse<Rs> = runCatching {
        responseMapper.fromSuccess(service.deleteById(UUID.fromString(id)))
    }.getOrElse {
        responseMapper.fromInvalidBody(it.message!!)
    }

}