import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    val appVersionCode by extra(1)
    val appVersion by extra("1.0.0")

    val kotlinVersion by extra("1.3.31")
    val gdxVersion by extra("1.9.9")
    val ktxVersion by extra("1.9.9-b1")
    val junitVersion by extra("5.6.2")

    repositories {
        gradlePluginPortal()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.1")
        classpath(kotlin("gradle-plugin", kotlinVersion))
    }
}

plugins {
    base
}

allprojects {
    repositories {
        jcenter()
        google()
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> { kotlinOptions.jvmTarget = "1.8" }
}



