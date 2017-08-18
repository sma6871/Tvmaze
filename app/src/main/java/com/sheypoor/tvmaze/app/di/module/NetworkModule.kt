package com.sheypoor.tvmaze.app.di.module

import android.content.Context
import com.google.gson.Gson
import com.sheypoor.tvmaze.constants.Configs
import com.sheypoor.tvmaze.app.di.AppScope
import com.sheypoor.tvmaze.network.TvMazeApiService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

/**
 * Created by S.Masoud on 2017/02/23.
 */

@Module
class NetworkModule {

    @AppScope
    @Provides
    fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .build()
    }

    @AppScope
    @Provides
    fun cache(context: Context): Cache {
        return Cache(File(context.cacheDir, Configs.HTTP_CACHE_DIR),
                Configs.HTTP_CACHE_MAX_SIZE.toLong())
    }

    @AppScope
    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor()

        return logger.setLevel(HttpLoggingInterceptor.Level.BASIC)

    }

    @AppScope
    @Provides
    fun retrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Configs.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @AppScope
    @Provides
    fun tvMazeApiService(retrofit: Retrofit): TvMazeApiService {
        return retrofit.create(TvMazeApiService::class.java)
    }

    @AppScope
    @Provides
    fun gson(): Gson {
        return Gson()
    }

}
