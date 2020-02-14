package com.vicky7230.tasker.data.network

import com.google.gson.JsonElement
import retrofit2.Response


interface ApiHelper {

    suspend fun generateOtp(email: String): Response<JsonElement>
}