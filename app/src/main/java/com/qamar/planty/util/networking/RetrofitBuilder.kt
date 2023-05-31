package com.qamar.planty.util.networking

import android.content.Context
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.qamar.planty.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitBuilder @Inject constructor(
    @ApplicationContext private val context: Context) {
    private var okHttpClientBuilder: OkHttpClient.Builder? = null
    private var interceptors = mutableListOf<Interceptor>()
    private var authenticator: Authenticator? = null
    private var baseUrl: String = ""
    private val TIME_OUT = 80 * 1000L

    init {
        baseUrl = BuildConfig.baseUrl
    }
    fun addInterceptors(vararg interceptor: Interceptor): RetrofitBuilder {
        interceptors.addAll(interceptor)
        return this
    }

    fun build(): Retrofit {
        val clientBuilder = okHttpClientBuilder ?: OkHttpClient.Builder().apply {
            connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            val loggingInterceptor = LoggingInterceptor.Builder()
                .setLevel(Level.BODY)
                .log(Platform.INFO)
                .request("|==Req==|  ")
                .response("|==Response==|  ")
                .build()
            if(BuildConfig.DEBUG) {
                addInterceptor(loggingInterceptor)
            }
            val auth: Authenticator? = when {
                authenticator != null -> authenticator
                else -> null
            }
            auth?.let { authenticator(it) }
            interceptors.forEach { addInterceptor(it) }
        }

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}