dependencies {
    implementation(project(mapOf("path" to ":core:core_http")))
    implementation(project(mapOf("path" to ":core:core_sw")))
    implementation(libs.coreKtx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.bundles.test)
}