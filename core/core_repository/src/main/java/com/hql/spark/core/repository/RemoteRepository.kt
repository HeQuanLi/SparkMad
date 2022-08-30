package com.hql.spark.core.repository

import com.hql.spark.core.http.RetrofitFactory
import com.hql.spark.core.http.response.ApiResponse
import com.hql.spark.core.http.test.ApiResult
import com.hql.spark.core.repository.home.HomeService
import com.hql.spark.core.repository.test.PageData

/**
 * @author HQL
 * Created on 2021/11/22
 * Desc:
 */

class RemoteRepository : BaseRepository() {

    private val homeService: HomeService = RetrofitFactory.instance.create(HomeService::class.java)

    private val posterService: PosterService = RetrofitFactory.instance.create(PosterService::class.java)

    companion object {
        val me: RemoteRepository by lazy(RemoteRepository::class.java) {
            RemoteRepository()
        }
    }

    suspend fun getHomeArticleList2(): ApiResponse<PageData> {
        return executeHttp {
            homeService.getHomeArticleList2()
        }
    }

    suspend operator fun invoke(): ApiResult<List<String>> {
        return posterService.fetchPosters()
    }
}