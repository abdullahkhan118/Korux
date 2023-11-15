package com.horux.microservices.authenticate.controllers

import com.horux.authentication.jwt.controllers.JwtAuthController
import com.horux.authentication.models.AuthenticationModel
import com.horux.authentication.models.RegisterModel
import com.horux.microservices.authenticate.models.AuthenticatedUser
import com.horux.microservices.authenticate.repository.AuthenticationRepository
import com.horux.microservices.authenticate.services.AuthenticationService
import jakarta.validation.Valid
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("public/auth")
class AuthenticationController(override val service: AuthenticationService) :
    JwtAuthController<AuthenticatedUser,
            UUID,
            AuthenticationService,
            AuthenticationRepository> {

    @PostMapping("register")
    fun registerUser(@Valid @RequestBody body: RegisterModel.Request): RegisterModel.Response =
        with(service.registerUser(AuthenticatedUser(username = body.username, password = body.password))) {
            RegisterModel.Response("User with id = $id has been created")
        }

    @PostMapping("authenticate")
    override fun authenticateUser(@Valid @RequestBody body: AuthenticationModel.Request): AuthenticationModel.Response =
        super.authenticateUser(body)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun exceptionHandler(exception: MethodArgumentNotValidException): HashMap<String, String> {

        val errors = hashMapOf<String, String>()

        exception.bindingResult.allErrors.forEach {
            errors.put(it.objectName, it.defaultMessage.toString())
        }

        return errors
    }

}