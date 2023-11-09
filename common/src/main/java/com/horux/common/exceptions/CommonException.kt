package com.horux.common.exceptions

fun AlreadyExistsException(): Exception = Exception("with this id already exists")
fun NotFoundException(): Exception = Exception("with this id was not found")

fun CollectionEmptyException() : Exception = Exception("collection is empty")