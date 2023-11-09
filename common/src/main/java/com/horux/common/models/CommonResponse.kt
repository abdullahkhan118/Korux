package com.horux.common.models

import org.springframework.http.HttpStatus

class CommonResponse<T>(
    val success: Boolean,
    val status: HttpStatus,
    val body: T?,
    val message: String,
    val errors: List<ResponseError>
)