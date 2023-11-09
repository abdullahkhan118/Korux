package com.horux.common.helper

import java.util.*

interface ServiceHelper<T: Any> {

    fun exists(data: Optional<T>): Boolean = !data.isEmpty

}