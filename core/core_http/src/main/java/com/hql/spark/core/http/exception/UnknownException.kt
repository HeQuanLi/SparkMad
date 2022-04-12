package com.hql.spark.core.http.exception

import android.util.Log
import com.hql.spark.core.http.BuildConfig

/**
 * @author HQL
 * Created on 2021/12/10
 * Desc: 未知错误
 */

object UnknownException {

    fun handle(t: Throwable): Pair<String, Int> {
        if (BuildConfig.DEBUG) {
            Log.d("HTTP", t.localizedMessage)
        }
        return Pair("未知错误", -1)
    }
}