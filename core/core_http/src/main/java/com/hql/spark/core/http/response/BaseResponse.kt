package com.hql.spark.core.http.response

/**
 * @author HQL
 * Created on 2021/11/5
 * Desc:
 */

open class BaseResponse<T>(val data: T?, val errorCode: Int?, val errorMsg: String?) {
    fun isSuccess(): Boolean {
        return errorCode == 200
    }
}