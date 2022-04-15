android {
    defaultConfig {
        //applicationId = "com.hql.spark.module.main"
    }
//    resourcePrefix = "module_main_"
}

dependencies {
    implementation(libs.coreKtx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(project(mapOf("path" to ":module:module_base")))
    testImplementation(libs.bundles.test)
}