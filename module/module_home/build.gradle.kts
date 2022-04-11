android {
    println("project.name=${project.name}")
    defaultConfig {
        val runModuleName: String by project
        if (runModuleName.contains(project.name)) {
//            applicationId = "com.hql.spark.module.home"
            print("runModuleName.contains(project.name) ${runModuleName.contains(project.name)}")
        }
    }
    resourcePrefix = "module_home_"
}

dependencies {
    implementation(libs.coreKtx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(project(mapOf("path" to ":module:module_base")))
    testImplementation(libs.bundles.test)
}