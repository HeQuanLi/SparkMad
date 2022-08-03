package com.hql.spark.module.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hql.spark.core.repository.RemoteRepository
import com.hql.spark.core.repository.test.PageData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    val liveDataPageData = MutableLiveData<PageData>()

    fun test() {
        viewModelScope.launch {
            RemoteRepository.me.getHomeArticleList2().apply {
                this.data?.let { result ->
                    withContext(Dispatchers.Main) {
                        liveDataPageData.value = result
                    }
                }
            }
        }
    }
}