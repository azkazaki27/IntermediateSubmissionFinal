package com.azka.intermediatesubmissionfinal.data

import com.azka.intermediatesubmissionfinal.data.remote.response.BaseResponse
import com.azka.intermediatesubmissionfinal.data.remote.response.LoginRequest
import com.azka.intermediatesubmissionfinal.data.remote.response.LoginResponse
import com.azka.intermediatesubmissionfinal.data.remote.response.RegisterRequest
import com.azka.intermediatesubmissionfinal.data.remote.response.StoriesResponse
import com.azka.intermediatesubmissionfinal.data.remote.response.StoryResponse
import com.azka.intermediatesubmissionfinal.data.remote.retrofit.ApiService
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call

class TestApiService: ApiService {
    override fun login(loginRequest: LoginRequest): Call<LoginResponse> {
        TODO("Not yet implemented")
    }

    override fun register(registerRequest: RegisterRequest): Call<BaseResponse> {
        TODO("Not yet implemented")
    }

    override fun getStory(token: String, id: Int): Call<StoryResponse> {
        TODO("Not yet implemented")
    }

    override fun getStories(
        token: String,
        page: Int?,
        size: Int?,
        location: Int
    ): Call<StoriesResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getStoriesWithLoc(
        token: String,
        page: Int?,
        size: Int?,
        location: Int
    ): StoriesResponse {
        TODO("Not yet implemented")
    }

    override fun uploadStory(
        token: String,
        file: MultipartBody.Part,
        description: RequestBody,
        lat: Double?,
        lon: Double?
    ): Call<BaseResponse> {
        TODO("Not yet implemented")
    }
}