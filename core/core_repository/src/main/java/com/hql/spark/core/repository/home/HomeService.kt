package com.hql.spark.core.repository.home

import com.hql.spark.core.http.response.ApiResponse
import com.hql.spark.core.http.utils.HttpConstant
import com.hql.spark.core.repository.test.PageData
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * @author HQL
 * Created on 2021/11/22
 * Desc:
 */

interface HomeService {

    @Headers(HttpConstant.BASE_DOMAIN)
    @GET("article/list/0/json")
    suspend fun getHomeArticleList2(): ApiResponse<PageData>

}