package com.nfc.knobeeassignment.network

import com.nfc.knobeeassignment.model.PostResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("dummyApi.json")
    suspend fun getPosts():ApiResponse<PostResponse>
}