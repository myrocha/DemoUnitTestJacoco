package com.example.workshoptest.model.mapper

import com.example.workshoptest.model.UserResponse
import com.example.workshoptest.model.entity.User

class UserMapper {
    fun mapToUserEntity(userResponse: UserResponse): User {
        return User(userResponse.id, userResponse.name, userResponse.email, userResponse.cpf, userResponse.token)
    }
}