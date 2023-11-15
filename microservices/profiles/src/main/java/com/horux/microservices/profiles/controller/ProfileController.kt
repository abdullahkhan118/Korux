package com.horux.microservices.profiles.controller

import com.horux.common.controllers.CrudController
import com.horux.common.models.CommonResponse
import com.horux.microservices.entities.ProfileDao
import com.horux.microservices.profiles.mappers.ProfileListResponseMapper
import com.horux.microservices.profiles.mappers.ProfileRequestMapper
import com.horux.microservices.profiles.mappers.ProfileResponseMapper
import com.horux.microservices.profiles.models.request.ProfileRequest
import com.horux.microservices.profiles.models.response.ProfileResponse
import com.horux.microservices.profiles.services.ProfileService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController("UserProfileController")
@RequestMapping("api/v1/profiles")
class ProfileController(
    override val service: ProfileService,
    override val requestMapper: ProfileRequestMapper,
    override val responseMapper: ProfileResponseMapper,
    override val listResponseMapper: ProfileListResponseMapper
) : CrudController<ProfileRequest, ProfileResponse, ProfileDao,UUID, ProfileService> {


    @PostMapping("create")
    override fun create(@RequestBody body: ProfileRequest): CommonResponse<ProfileResponse> {
        return super.create(body)
    }

    @GetMapping("{id}")
    override fun getById(@PathVariable("id") id: UUID): CommonResponse<ProfileResponse> {
        return super.getById(id)
    }

    @GetMapping("all")
    override fun getAll(): CommonResponse<List<ProfileResponse>> {
        return super.getAll()
    }

    @PutMapping("{id}")
    override fun update(
        @PathVariable("id") id: UUID,
        @Valid @RequestBody body: ProfileRequest
    ): CommonResponse<ProfileResponse> {
        return super.update(id, body)
    }

    @DeleteMapping("{id}")
    override fun delete(@PathVariable("id") id: UUID): CommonResponse<ProfileResponse> {
        return super.delete(id)
    }

}