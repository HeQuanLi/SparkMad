package com.hql.spark.core.http.utils

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.ObservableTransformer
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * @author HQL
 * Created on 2021/11/29
 * Desc: 线程切换
 */

object RxUtils {
    fun <T> ioToMain(): ObservableTransformer<T, T> {
        return ObservableTransformer<T, T> { upstream ->
            upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }
}