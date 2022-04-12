package com.hql.spark.core.http.exception

import retrofit2.HttpException

/**
 * @author HQL
 * Created on 2021/12/10
 * Desc:
 */

object NetWorkException {
    //未经授权
    private const val UNAUTHORIZED = 401

    //服务器拒绝请求
    private const val FORBIDDEN = 403

    //服务器找不到请求
    private const val NOT_FOUND = 404

    //服务器等候请求时发生超时
    private const val REQUEST_TIMEOUT = 408

    //服务器遇到错误，无法完成请求
    private const val INTERNAL_SERVER_ERROR = 500

    //网关错误
    private const val BAD_GATEWAY = 502

    //服务不可用
    private const val SERVICE_UNAVAILABLE = 503

    //网关超时
    private const val GATEWAY_TIMEOUT = 504

    fun handle(t: HttpException): Pair<String, Int> {
        return when (t.code()) {
            UNAUTHORIZED -> {
                Pair("未经授权", UNAUTHORIZED)
            }
            FORBIDDEN -> {
                Pair("服务器拒绝请求", FORBIDDEN)
            }
            NOT_FOUND -> {
                Pair("服务器找不到请求", NOT_FOUND)
            }
            REQUEST_TIMEOUT -> {
                Pair("服务器等候请求时发生超时", REQUEST_TIMEOUT)
            }
            INTERNAL_SERVER_ERROR -> {
                Pair("服务器发生错误", INTERNAL_SERVER_ERROR)
            }
            BAD_GATEWAY -> {
                Pair("网关错误", BAD_GATEWAY)
            }
            SERVICE_UNAVAILABLE -> {
                Pair("服务不可用", SERVICE_UNAVAILABLE)
            }
            GATEWAY_TIMEOUT -> {
                Pair("网关超时", GATEWAY_TIMEOUT)
            }
            else -> UnknownException.handle(t)
        }
    }
}