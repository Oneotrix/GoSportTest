package com.oneotrix.gosporttest.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.oneotrix.gosporttest.data.network.Api
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

@Module
class ModuleRetrofit {

    @Provides
    fun apiService(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @Provides
    fun retrofitService(
        convertedFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(convertedFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun jsonConvertedFactory(json: Json, contentType: MediaType): Converter.Factory {
        return json.asConverterFactory(contentType)
    }

    @Provides
    fun json(): Json {
        return Json
    }

    @Provides
    fun contentType(): MediaType {
        return "application/json".toMediaType()
    }
}