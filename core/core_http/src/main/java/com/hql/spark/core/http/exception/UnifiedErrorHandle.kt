package com.hql.spark.core.http.exception

import android.net.ParseException
import com.google.gson.JsonParseException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

/**
 * @author HQL
 * Created on 2021/12/10
 * Desc: 错误统一处理
 */

object UnifiedErrorHandle {

    fun handleError(t: Throwable): Pair<String?, Int>? {
        if (t is HttpException) {
            return NetWorkException.handle(t)
        }
        if (t is ServerException) {
            return Pair(t.message, t.code)
        }

        if (t is JsonParseException
            || t is JSONException
            || t is ParseException
        ) {
            return Pair("解析错误", 1001)
        }

        if (t is ConnectException
            || t is SocketTimeoutException
            || t is UnknownHostException
        ) {
            return Pair("连接失败", 1002)
        }

        if (t is SSLHandshakeException) {
            return Pair("证书验证失败", 1003)
        }

        return UnknownException.handle(t)
    }
}