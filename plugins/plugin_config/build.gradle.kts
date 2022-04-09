import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = libs.versions.jvmTargetVersion.toString()
}

gradlePlugin {
    plugins.register("dependencies") {
        id = "GradleCommonConfigPlugin"
        implementationClass = "com.hql.spark.plugins.plugin.config.GradleCommonConfigPlugin"
    }
}

dependencies {
    implementation(gradleApi())
    implementation(libs.kotlinGradlePlugin)
    implementation(libs.gradle)
}
