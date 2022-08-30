package com.hql.spark.core.repository

import com.hql.spark.core.http.test.ApiResult
import retrofit2.http.GET

/**
 * @author HQL
 * @date 2022/8/30
 */
interface PosterService {
    @GET("DisneyPosters.json")
    suspend fun fetchPosters(): ApiResult<List<String>>
}

