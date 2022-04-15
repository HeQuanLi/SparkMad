pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

//7.4之后就是稳定版本了,这行需要放在dependencyResolutionManagement前面
//enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
/*    versionCatalogs {
        create("libs") {
            from(files("../../libs.versions.toml"))
        }
    }*/
}