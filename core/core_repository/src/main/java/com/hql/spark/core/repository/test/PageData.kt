package com.hql.spark.core.repository.test

data class PageData(
    val curPage: Int?,
    val datas: List<ListBean>?,
    val offset: Int?,
    val over: Boolean?,
    val pageCount: Int?,
    val size: Int?,
    val total: Int?
)