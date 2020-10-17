package com.example.myapplication.network

import android.content.Context
import com.example.myapplication.Constants.API_CALL_TIMEOUT_IN_SECONDS
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


class HttpClientBuilderFactory() {

    private val okHttpClient by lazy { OkHttpClient() }

    fun create(): OkHttpClient.Builder = okHttpClient.newBuilder().apply {
        connectTimeout(API_CALL_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        readTimeout(API_CALL_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
    }
}