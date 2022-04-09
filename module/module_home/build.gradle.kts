android {
    print("project.name=${project.name}")
    defaultConfig {
        //applicationId = "com.hql.spark.module.home"
    }
    resourcePrefix = "module_home_"
}

dependencies {
    implementation(libs.coreKtx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.bundles.test)
}