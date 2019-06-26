package com.example.workshoptest.model

import com.example.workshoptest.model.entity.User
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.io.StreamTokenizer

/**
 * o servidor retorna este objeto
 */
class UserResponse(
    @SerializedName("id")  val id: Int,
    @SerializedName("name")  val name: String,
    @SerializedName("email")  val email: String,
    @SerializedName("cpf")  val cpf: String,
    @SerializedName ("token") val token : String
) : Serializable