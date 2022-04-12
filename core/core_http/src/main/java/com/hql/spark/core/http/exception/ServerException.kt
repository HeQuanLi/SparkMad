package com.hql.spark.core.http.exception

/**
 * @author HQL
 * Created on 2021/12/9
 * Desc: 服务器相关的错误
 */

class ServerException(msg: String?, val code: Int) : RuntimeException(msg)