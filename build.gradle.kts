// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.1.3" apply false
    id("com.android.library") version "7.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id("GradleCommonConfigPlugin") apply false
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
val runModuleName: String by project

subprojects {
    //所有module的project都是要下面的插件
    apply(plugin = "GradleCommonConfigPlugin")
    if ( "app" == project.name) {
        apply(plugin = "com.android.application")
    } else {
        apply(plugin = "com.android.library")
    }
}
