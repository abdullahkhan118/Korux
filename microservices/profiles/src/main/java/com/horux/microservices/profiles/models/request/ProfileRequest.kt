package com.horux.microservices.profiles.models.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class ProfileRequest(
    @get:NotBlank(message = "Name can't be blank")
    @get:Size(min = 4, max = 50, message = "Name must be between the lengths of 4 and 50")
    val name: String,
    val bio: String,
    @get:NotBlank(message = "Photo is required")
    val photo: String,
    @get:NotBlank(message = "Email cannot be blank")
    @get:Email(message = "Invalid email format")
    val emailAddress: String,
    @get:NotBlank(message = "Password cannot be blank")
    @get:Size(min = 8, message = "Password must have at least 8 characters")
    @get:Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$)",
        message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
    val password: String
)
