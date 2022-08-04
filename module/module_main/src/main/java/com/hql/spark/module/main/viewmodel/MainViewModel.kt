package com.hql.spark.module.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hql.spark.core.repository.RemoteRepository
import com.hql.spark.core.repository.test.PageData

class MainViewModel : ViewModel() {

    val liveDataPageData = MutableLiveData<PageData>()

    suspend fun test() = RemoteRepository.me.getHomeArticleList2()

}