dependencies {
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.gson)
    implementation(libs.rxjava)
    implementation(libs.rxandroid)
    implementation(libs.annotation)
    implementation(libs.rxjavaAdapter)
    implementation(project(mapOf("path" to ":core:core_base")))
    testImplementation(libs.bundles.test)
}
