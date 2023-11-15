package com.horux.authentication.jwt.controllers

import com.horux.authentication.controllers.AuthController
import com.horux.authentication.jwt.models.JwtAuthenticatedUser
import com.horux.authentication.jwt.repositories.JwtAuthenticateUserRepository
import com.horux.authentication.jwt.services.JwtService


interface JwtAuthController<T : JwtAuthenticatedUser<ID>, ID, S : JwtService<T, ID,R>, R : JwtAuthenticateUserRepository<T, ID>> :
    AuthController<T, ID, S,R>