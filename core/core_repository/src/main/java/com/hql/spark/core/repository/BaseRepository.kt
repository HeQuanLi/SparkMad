package com.hql.spark.core.repository

import com.hql.spark.core.http.response.*

open class BaseRepository {

    suspend fun <T : Any> executeHttp(block: suspend () -> ApiResponse<T>): ApiResponse<T> {
        runCatching {
            block.invoke()
        }.onSuccess { data: ApiResponse<T> ->
            return handleHttpOk(data)
        }.onFailure { e ->
            return handleHttpError(e)
        }
        return ApiEmpty()
    }

    /**
     * 非后台返回错误，捕获到的异常
     */
    private fun <T : Any> handleHttpError(e: Throwable): ApiException<T> {
        if (BuildConfig.DEBUG) e.printStackTrace()
//        handlingExceptions(e)
        return ApiException(e)
    }

    /**
     * 返回200，但是还要判断isSuccess
     */
    private fun <T : Any> handleHttpOk(data: ApiResponse<T>): ApiResponse<T> {
        return if (data.isSuccess) {
            getHttpSuccessResponse(data)
        } else {
//            handlingApiExceptions(data.errorCode, data.errorMsg)
            ApiError(data.errorCode, data.errorMsg)
        }
    }

    /**
     * 成功和数据为空的处理
     */
    private fun <T : Any> getHttpSuccessResponse(response: ApiResponse<T>): ApiResponse<T> {
        return if (response.data == null || response.data is List<*> && (response.data as List<*>).isEmpty()) {
            ApiEmpty()
        } else {
            ApiSuccess(response.data!!)
        }
    }
}