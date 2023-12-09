package com.azka.intermediatesubmissionfinal.di

import android.content.Context
import com.azka.intermediatesubmissionfinal.data.AuthRepository
import com.azka.intermediatesubmissionfinal.data.StoryRepository
import com.azka.intermediatesubmissionfinal.data.local.room.AppDatabase
import com.azka.intermediatesubmissionfinal.data.remote.retrofit.ApiConfig

object Injection {
    fun provideAuthRepository(context: Context): AuthRepository {
        val apiService = ApiConfig.getApiService()
        return AuthRepository.getInstance(apiService)
    }

    fun provideStoryRepository(context: Context): StoryRepository {
        val database = AppDatabase.getDatabase(context)
        val apiService = ApiConfig.getApiService()
        return StoryRepository.getInstance(apiService,database)
    }
}