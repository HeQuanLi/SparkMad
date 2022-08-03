dependencies {

    api(project(mapOf("path" to ":core:core_sw")))
    api(project(mapOf("path" to ":core:core_repository")))

    api(libs.coreKtx)
    api(libs.appcompat)
    api(libs.material)
    api(libs.viewmodel)
    api(libs.constraintlayout)
    api(libs.coroutines)
    api(libs.fragmentKtx)
    api(libs.activityKtx)

    testApi(libs.bundles.test)
}