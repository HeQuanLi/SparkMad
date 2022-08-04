package com.hql.spark.module.base

import androidx.lifecycle.lifecycleScope
import com.hql.spark.core.http.response.ApiResponse
import com.hql.spark.core.repository.ResultBuilder
import com.hql.spark.core.repository.parseData
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

/**
 * 第一种方式：用完就丢。请求带Loading&&不需要声明LiveData
 * 界面逻辑（尤其是在涉及 Context 等界面类型时）应位于界面中，而非 ViewModel 中。
 */
fun <T : Any> IView.launchFlow(
    requestBlock: suspend () -> ApiResponse<T>,
    showLoading: Boolean = true,
    listenerBuilder: ResultBuilder<T>.() -> Unit
) {
    lifecycleScope.launch {
        flow {
            emit(requestBlock())
        }.onStart {
            if (showLoading) showLoading()
        }.onCompletion {
            if (showLoading) dismissLoading()
        }.collect { response ->
            response.parseData(listenerBuilder)
        }
    }
}

