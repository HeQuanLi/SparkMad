package com.hql.spark.core.http

import com.hql.spark.core.http.interceptor.CommonInterceptor
import com.hql.spark.core.http.interceptor.DynamicBaseUrlInterceptor
import com.hql.spark.core.http.interceptor.LoggingInterceptor
import com.hql.spark.core.http.test.NetworkResultCallAdapterFactory
import com.hql.spark.core.http.utils.HttpConstant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author HQL
 * Created on 2021/6/22
 * Desc:
 */

class RetrofitFactory private constructor() {

    private val retrofit: Retrofit
    private val defaultTimeout = 30L //超时时间
    private val defaultReadTimeout = 30L //读取时间
    private val defaultWriteTimeout = 30L //读取时间

    init {

        val okhttp = OkHttpClient().newBuilder().apply {
            connectTimeout(defaultTimeout, TimeUnit.SECONDS)
            readTimeout(defaultReadTimeout, TimeUnit.SECONDS)
            writeTimeout(defaultWriteTimeout, TimeUnit.SECONDS)
            addInterceptor(DynamicBaseUrlInterceptor())
            addInterceptor(LoggingInterceptor.Builder().build())
            addInterceptor(CommonInterceptor())
        }.build()

        retrofit = Retrofit.Builder().apply {
            baseUrl(HttpConstant.BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(NetworkResultCallAdapterFactory.create())
            client(okhttp)
        }.build()
    }

    companion object {
        val instance by lazy {
            RetrofitFactory()
        }
    }

    fun <T> create(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}