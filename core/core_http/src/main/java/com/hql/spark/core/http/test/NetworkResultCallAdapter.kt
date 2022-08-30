package com.hql.spark.core.http.test

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

/**
 * @author HQL
 * @date 2022/8/30
 */
class NetworkResultCallAdapter(
    private val resultType: Type
) : CallAdapter<Type, Call<ApiResult<Type>>> {

    override fun responseType(): Type = resultType

    override fun adapt(call: Call<Type>): Call<ApiResult<Type>> {
        return NetworkResultCall(call)
    }
}