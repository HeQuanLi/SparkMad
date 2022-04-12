package com.hql.spark.core.http.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author HQL
 * Created on 2021/11/19
 * Desc:
 */

class CommonInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("charset", "UTF-8")
            .build()
        return chain.proceed(request)
    }
}