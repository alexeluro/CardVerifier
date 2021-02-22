package com.inspiredcoda.cardverifier.di

import android.app.Application
import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.inspiredcoda.cardverifier.data.Api
import com.inspiredcoda.cardverifier.data.CustomInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun getRetrofitInstance(@ApplicationContext context: Context): Retrofit {
        val client = OkHttpClient.Builder()
                .callTimeout(1000, TimeUnit.SECONDS)
                .connectTimeout(1000, TimeUnit.SECONDS)
                .readTimeout(1000, TimeUnit.SECONDS)
                .writeTimeout(1000, TimeUnit.SECONDS)
                .addInterceptor(CustomInterceptor(context))
                .addNetworkInterceptor(StethoInterceptor())
                .build()

        return Retrofit.Builder()
                .baseUrl("https://delivrr-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
                .client(client)
                .build()
    }

    @Singleton
    @Provides
    fun getApiInstance(retrofit: Retrofit) = retrofit.create(Api::class.java)


}