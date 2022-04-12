package com.hql.spark.core.http.response

/**
 * @author HQL
 * Created on 2021/11/5
 * Desc:
 */

open class BaseResponse<T>(var data: T, var errorCode: Int = -1, var errorMsg: String = "") {
    fun isSuccess(): Boolean {
        return errorCode == 200
    }
}