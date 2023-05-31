package com.qamar.planty.di

import android.content.SharedPreferences
import com.qamar.planty.data.source.network.plants.repository.PlantsRepository
import com.qamar.planty.data.source.network.plants.service.PlantsServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providerPlantsRepository(
        apiService: PlantsServiceApi,
    ): PlantsRepository {
        return PlantsRepository(apiService)
    }
}