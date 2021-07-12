package com.example.starwars.retrofit

import com.example.starwars.BuildConfig.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AdapterRest {

    var clientEndPoints : ClientEndPoints? = null

    fun init() {
        var loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        var client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(object : Interceptor{
                override fun intercept(chain: Interceptor.Chain): Response {
                    var request = chain.request().newBuilder()
                    return chain.proceed(request.build())
                }
            })
            .build()


        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        clientEndPoints = retrofit.create(ClientEndPoints::class.java)


    }


}