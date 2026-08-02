package com.pradeep.novacrypto.di

import com.pradeep.novacrypto.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesOkHttp(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }).addInterceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("x-cg-demo-api-key", BuildConfig.API_KEY)
            .build()
        chain.proceed(request)
    }.build()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providesCoingeckoApi(retrofit: Retrofit): com.pradeep.novacrypto.data.api.CoingeckoApi =
        retrofit.create(com.pradeep.novacrypto.data.api.CoingeckoApi::class.java)

    @Provides
    @Singleton
    fun providesDispatcherProvider(): com.pradeep.novacrypto.core.dispature.DispatcherProvider =
        com.pradeep.novacrypto.core.dispature.DispatcherProviderImpl()
}