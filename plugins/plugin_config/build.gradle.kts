import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

gradlePlugin {
    plugins.register("dependencies") {
        id = "GradleCommonConfigPlugin"
        implementationClass = "com.hql.spark.plugins.plugin.config.GradleCommonConfigPlugin"
    }
}

dependencies {
    implementation(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
    implementation("com.android.tools.build:gradle:7.1.3")
}
