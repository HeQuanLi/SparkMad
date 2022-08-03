package com.hql.spark.core.repository

import com.hql.spark.core.http.RetrofitFactory
import com.hql.spark.core.http.response.BaseResponse
import com.hql.spark.core.repository.home.HomeService
import com.hql.spark.core.repository.test.PageData

/**
 * @author HQL
 * Created on 2021/11/22
 * Desc:
 */

class RemoteRepository {

    private val homeService: HomeService = RetrofitFactory.instance.create(HomeService::class.java)

    companion object {
        val me: RemoteRepository by lazy(RemoteRepository::class.java) {
            RemoteRepository()
        }
    }

    suspend fun getHomeArticleList2(): BaseResponse<PageData> {
        return homeService.getHomeArticleList2()
    }
}