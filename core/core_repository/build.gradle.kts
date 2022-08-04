dependencies {

    api(project(mapOf("path" to ":core:core_http")))

    implementation(libs.retrofit)
    implementation(libs.livedata)

    testImplementation(libs.bundles.test)
}