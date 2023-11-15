package com.horux.authentication.jwt.tokens

import com.horux.authentication.constants.Headers
import com.horux.authentication.jwt.models.JwtAuthenticatedUser
import com.horux.authentication.jwt.services.JwtService
import com.horux.authentication.services.AuthService
import com.horux.authentication.tokens.Authentication
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource

interface JwtAuthentication<T : JwtAuthenticatedUser<ID>, ID> :
    Authentication<T, ID>