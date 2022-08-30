package com.hql.spark.module.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hql.spark.core.http.test.onError
import com.hql.spark.core.http.test.onException
import com.hql.spark.core.http.test.onSuccess
import com.hql.spark.core.repository.RemoteRepository
import com.hql.spark.core.repository.test.PageData
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val liveDataPageData = MutableLiveData<PageData>()

    suspend fun test() = RemoteRepository.me.getHomeArticleList2()

    fun test2() {
        viewModelScope.launch {
            RemoteRepository.me.invoke()
                .onSuccess { posterList ->
                    posterFlow.emit(posterList)
                }.onError { code, message ->
                    errorFlow.emit("$code $message")
                }.onException {
                    errorFlow.emit("${it.message}")
                }
        }
    }

}