package com.qamar.planty.di

import com.qamar.planty.data.source.network.plants.service.PlantsServiceApi
import com.qamar.planty.util.networking.HeaderInterceptor
import com.qamar.planty.util.networking.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkingModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        retrofitBuilder: RetrofitBuilder,
        headerInterceptor: HeaderInterceptor
    ): Retrofit =
        retrofitBuilder
            .addInterceptors(headerInterceptor)
            .build()

    @Provides
    @Singleton
    fun providePlantsApi(retrofit: Retrofit): PlantsServiceApi =
        retrofit.create(PlantsServiceApi::class.java)
}