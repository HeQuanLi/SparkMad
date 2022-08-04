package com.hql.spark.core.repository

import com.hql.spark.core.http.response.*

fun <T : Any> ApiResponse<T>.parseData(listenerBuilder: ResultBuilder<T>.() -> Unit) {

    val listener = ResultBuilder<T>().also(listenerBuilder)

    when (this) {
        is ApiSuccess -> listener.onSuccess(this.data)

        is ApiEmpty -> listener.onDataEmpty()

        is ApiError -> listener.onFailed(this.errorCode, this.errorMsg)

        is ApiException -> listener.onError(this.throwable)
    }
    listener.onComplete()
}

class ResultBuilder<T> {
    var onSuccess: (data: T?) -> Unit = {}

    var onDataEmpty: () -> Unit = {}

    var onFailed: (errorCode: Int?, errorMsg: String?) -> Unit = { _, _ -> }

    var onError: (e: Throwable?) -> Unit = { _ -> }

    var onComplete: () -> Unit = {}
}