package com.hql.spark.core.http.response

import java.io.Serializable

/**
 * @author HQL
 * Created on 2021/11/5
 * Desc:
 */

open class ApiResponse<T : Any>(
    open val data: T? = null,
    open val errorCode: Int? = null,
    open val errorMsg: String? = null
) : Serializable {

    val isSuccess: Boolean
        get() = errorCode == 0
}

data class ApiSuccess<T : Any>(override val data: T?) : ApiResponse<T>(data = data)
data class ApiError<T : Any>(override val errorCode: Int?, override val errorMsg: String?) :
    ApiResponse<T>(errorCode = errorCode, errorMsg = errorMsg)

data class ApiException<T : Any>(val throwable: Throwable?) : ApiResponse<T>()

class ApiEmpty<T : Any> : ApiResponse<T>()