package com.horux.common.mappers

interface IRequestMapper<Rq,T> {

    fun requestToData(request: Rq) : T

}