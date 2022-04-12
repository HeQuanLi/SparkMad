package com.hql.spark.core.http.mapper

import com.hql.spark.core.http.exception.UnifiedErrorHandle
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

/**
 * @author HQL
 * Created on 2021/12/10
 * Desc:
 */

abstract class BaseObserver<T> : Observer<T> {

    override fun onSubscribe(d: Disposable?) {
    }

    override fun onNext(t: T) {
        succeed(t)
    }

    override fun onError(e: Throwable) {
        val result = UnifiedErrorHandle.handleError(e)
        error(result?.first, result?.second)
    }

    override fun onComplete() {
    }

    abstract fun succeed(t: T)

    abstract fun error(msg: String?, code: Int?)

}