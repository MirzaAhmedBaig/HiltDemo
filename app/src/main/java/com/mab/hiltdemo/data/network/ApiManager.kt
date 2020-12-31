package com.mab.hiltdemo.data.network

import com.mab.hiltdemo.data.network.response.SocialLoginResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiManager {
    @GET(EndPoints.GET_USER_EXIST)
    suspend fun isUserExist(@Query("Email") email: String): SocialLoginResponse

}