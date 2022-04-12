package com.hql.spark.core.http.interceptor

import com.hql.spark.core.http.utils.HttpConstant
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * @author HQL
 * Created on 2021/12/8
 * Desc: 动态切换base url
 */
class DynamicBaseUrlInterceptor : Interceptor {

    companion object {
        const val domainName = "Domain-Name"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        //获取request
        val request: Request = chain.request()
        //从request中获取原有的HttpUrl实例oldHttpUrl
        val oldHttpUrl = request.url
        //获取request的创建者builder
        val builder: Request.Builder = request.newBuilder()
        //从request中获取headers，通过给定的键url_name
        val headerValues = request.headers(domainName)
        if (headerValues.isNotEmpty()) {
            //如果有这个header，先将配置的header删除，因此header仅用作app和okhttp之间使用
            builder.removeHeader(domainName)
            //匹配获得新的BaseUrl
            var newBaseUrl = when (headerValues[0]) {
                HttpConstant.BASE -> {
                    HttpConstant.BASE_URL.toHttpUrlOrNull()
                }
                HttpConstant.FAT -> {
                    HttpConstant.FAT_URL.toHttpUrlOrNull()
                }
                else -> {
                    oldHttpUrl
                }
            }
            //重建新的HttpUrl，修改需要修改的url部分
            val newFullUrl = oldHttpUrl
                .newBuilder()
                //.scheme("https") //更换网络协议
                .host(newBaseUrl!!.host) //更换主机名
                //.port(newBaseUrl.port) //更换端口
                //.removePathSegment(0) //移除第一个参数
                .build()
            return chain.proceed(builder.url(newFullUrl).build())
        }
        return chain.proceed(request)
    }
}