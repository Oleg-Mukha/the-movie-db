package com.olegatron.data.di.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class MovieInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val newUrl = request.url().newBuilder()
            .addQueryParameter("api_key", "8a6e50e02076a6fbf2e89472c5c77873")
            .build()

        val newRequest = request.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}