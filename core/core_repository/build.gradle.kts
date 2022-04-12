dependencies {
    implementation(project(mapOf("path" to ":core:core_http")))
    testImplementation(libs.bundles.test)
    implementation(libs.rxjava)
    implementation(libs.retrofit)
}