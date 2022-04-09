package com.hql.spark.plugins.plugin.config

import Versions
import com.android.build.gradle.*
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.PluginContainer
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/*
plugins {
    id 'com.android.library' //这个在subprojects单独处理
    id 'kotlin-android'
}
android {
    compileSdk 31
    defaultConfig {
        minSdk 21
        targetSdk 31
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles "consumer-rules.pro"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_11
        targetCompatibility JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = '11'
    }
}
dependencies {
    implementation fileTree(include: ['*.jar', '*.aar'], dir: 'libs')
    implementation 'androidx.core:core-ktx:1.3.2'
}
*/

/**
 * @author HQL
 * Created on 2021/12/7
 * Desc: gradle公共配置插件
 */

class GradleCommonConfigPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.config(project)
    }

    private fun PluginContainer.config(project: Project) {
        whenPluginAdded {
            when (this) {
                //com.android.application
                is AppPlugin -> {
                    //公共插件
                    project.configCommonPlugin()
                    //公共 android 配置项
                    project.extensions.getByType<AppExtension>().applyAppCommons(project)
                    //公共依赖
                    project.commonFileTree()
                }
                //com.android.library
                is LibraryPlugin -> {
                    //公共插件
                    project.configCommonPlugin()
                    //公共 android 配置项
                    project.extensions.getByType<LibraryExtension>().applyLibraryCommons(project)
                    //公共依赖
                    project.commonFileTree()
                }
            }
        }
    }

    /**
     * 公共依赖
     */
    private fun Project.commonFileTree() {
        dependencies.apply {
            add(
                "implementation",
                fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar")))
            )
            //add(implementation, (project(":baselib")))
            commonDependencies()
        }
    }

    private fun DependencyHandler.commonDependencies() {
//        add("implementation", "androidx.core:core-ktx:${Versions.core_ktx_version}")
    }

    /**
     * 公共插件配置
     */
    private fun Project.configCommonPlugin() {
        plugins.apply("kotlin-android")
    }

    /**
     * app Module 配置项，此处固定了 applicationId
     */
    private fun AppExtension.applyAppCommons(project: Project) {
        defaultConfig {
            applicationId = Versions.applicationId
        }
        applyBaseCommons(project)
    }

    /**
     * library Module 配置项
     */
    private fun LibraryExtension.applyLibraryCommons(project: Project) {
        applyBaseCommons(project)
    }

    private fun BaseExtension.applyBaseCommons(project: Project) {

        compileSdkVersion(Versions.compileSdkVersion)

        defaultConfig {
            minSdk = Versions.minSdkVersion
            targetSdk = Versions.targetSdkVersion
            versionCode = Versions.versionCode
            versionName = Versions.versionName
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        project.tasks.withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
}