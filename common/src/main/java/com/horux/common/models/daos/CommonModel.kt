package com.horux.common.models.daos

import jakarta.persistence.MappedSuperclass
import java.util.*

@MappedSuperclass
abstract class CommonModel : Any() {

    abstract val id: UUID

}
