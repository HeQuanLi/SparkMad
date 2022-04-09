android {
    defaultConfig {
        //applicationId = "com.hql.spark.module.login"
    }
    resourcePrefix = "module_login_"
}

dependencies {
    implementation(libs.coreKtx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.bundles.test)
}