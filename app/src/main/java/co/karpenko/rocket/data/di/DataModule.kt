package co.karpenko.rocket.data.di

import android.content.Context
import androidx.core.os.ConfigurationCompat
import androidx.multidex.BuildConfig
import co.karpenko.rocket.data.api.Api
import co.karpenko.rocket.data.di.DataModule.API_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton

/**
 * Created by Alexander Karpenko on 2022-04-25.
 * java.karpenko@gmail.com
 */

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    private const val API_URL = "https://api.spacexdata.com"
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
        val clientBuilder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        return Retrofit.Builder()
            .client(clientBuilder.build())
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideAuthenticationService(retrofit: Retrofit): Api = retrofit.create(
        Api::class.java
    )

    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}