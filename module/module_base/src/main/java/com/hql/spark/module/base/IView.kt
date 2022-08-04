package com.hql.spark.module.base

import androidx.lifecycle.LifecycleOwner

interface IView : LifecycleOwner {
    fun showLoading()

    fun dismissLoading()
}