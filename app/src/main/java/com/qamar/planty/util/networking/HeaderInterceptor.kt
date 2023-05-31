package com.qamar.planty.util.networking

import com.qamar.planty.util.handleExceptions
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        try {
            request = request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build()

        } catch (e: Exception) {
            handleExceptions<Exception>(e)
        }
        return chain.proceed(request)

    }
}