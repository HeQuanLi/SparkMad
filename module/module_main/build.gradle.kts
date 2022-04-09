android {
    defaultConfig {
        //applicationId = "com.hql.spark.module.main"
    }
    resourcePrefix = "module_main_"
}

dependencies {
    implementation(libs.coreKtx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.bundles.test)
}