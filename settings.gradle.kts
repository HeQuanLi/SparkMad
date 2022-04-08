pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
//7.4之后就是稳定版本了,这行需要放在dependencyResolutionManagement前面
enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            from(files("./libs.versions.toml"))
        }
    }
}
rootProject.name = "SparkMad"

include(":app")
include(":module:module_base")
include(":module:module_main")
include(":module:module_home")
include(":module:module_mine")
include(":module:module_login")
include(":core:core_base")
include(":core:core_http")
include(":core:core_mmkv")
