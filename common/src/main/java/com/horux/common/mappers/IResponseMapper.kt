package com.horux.common.mappers

import com.horux.common.models.CommonResponse
import com.horux.common.models.ResponseError
import org.springframework.http.HttpStatus
import java.util.*

interface IResponseMapper<T,Rs> {
    fun fromInvalidBody(vararg errors: String): CommonResponse<Rs> = CommonResponse(
        success = false,
        status = HttpStatus.BAD_REQUEST,
        body = null,
        message = "The task was unsuccessful",
        errors = mutableListOf<ResponseError>().also {
            errors.forEach {error ->
                it.add(ResponseError(error))
            }
        }
    )

    fun fromSuccess(data: T): CommonResponse<Rs> = CommonResponse(
        success = true,
        status = HttpStatus.OK,
        body = dataToResponse(data),
        message = "The task was successful",
        errors = emptyList()
    )

    fun dataToResponse(data: T): Rs

}