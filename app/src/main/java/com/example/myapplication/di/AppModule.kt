package com.example.myapplication.di



import com.example.myapplication.network.HttpClientBuilderFactory
import com.example.myapplication.network.Services
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesService(httpClient: HttpClientBuilderFactory): Services = Services.createService(httpClient)


    @Provides
    @Singleton
    fun provideHttpBuilderFactory() : HttpClientBuilderFactory = HttpClientBuilderFactory()



}