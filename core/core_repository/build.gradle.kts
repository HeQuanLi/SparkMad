dependencies {

    api(project(mapOf("path" to ":core:core_http")))

    implementation(libs.retrofit)

    testImplementation(libs.bundles.test)
}