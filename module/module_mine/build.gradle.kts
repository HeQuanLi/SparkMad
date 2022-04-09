android {
    defaultConfig {
        //applicationId = "com.hql.spark.module.mine"
    }
    resourcePrefix = "module_mine_"
}

dependencies {
    implementation(libs.coreKtx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.bundles.test)
}