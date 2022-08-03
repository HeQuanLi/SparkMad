dependencies {

    implementation(project(mapOf("path" to ":core:core_base")))

    implementation(libs.bundles.http)
    implementation(libs.annotation)

    testImplementation(libs.bundles.test)
}
