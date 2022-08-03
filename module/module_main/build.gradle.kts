android {
    defaultConfig {
        //applicationId = "com.hql.spark.module.main"
    }
//    resourcePrefix = "module_main_"
}

dependencies {
    api(project(mapOf("path" to ":module:module_base")))
}