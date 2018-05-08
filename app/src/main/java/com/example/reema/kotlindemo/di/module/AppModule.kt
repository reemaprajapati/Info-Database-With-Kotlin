package com.example.reema.kotlindemo.di.module

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import java.io.File
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
    }
//
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(application: Application): OkHttpClient {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BASIC
//
//        val cacheDir = File(application.cacheDir, UUID.randomUUID().toString())
//        // 10 MiB cache
//        val cache = Cache(cacheDir, 10 * 1024 * 1024)
//
//        return OkHttpClient.Builder()
//                .cache(cache)
//                .connectTimeout(30, TimeUnit.SECONDS)
//                .readTimeout(60, TimeUnit.SECONDS)
//                .writeTimeout(60, TimeUnit.SECONDS)
//                .addInterceptor(interceptor)
//                .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideApiService(gson: Gson, okHttpClient: OkHttpClient): ApiService {
//        return Retrofit.Builder()
//                .baseUrl("http://ip.jsontest.com/")
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(okHttpClient)
//                .build().create(ApiService::class.java)
//    }
}