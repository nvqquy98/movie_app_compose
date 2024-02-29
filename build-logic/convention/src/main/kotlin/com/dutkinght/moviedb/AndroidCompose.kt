package com.dutkinght.moviedb

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import java.io.File

/**
 * Configure Compose-specific options
 */


internal fun Project.configureAndroidCompose(commonExt: CommonExtension<*, *, *, *, *>) {
    commonExt.apply {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("androidxComposeCompiler").get().toString()
        }

        kotlinOptions {
            freeCompilerArgs += buildComposeMetricsParameter()
        }
    }
}

private fun Project.buildComposeMetricsParameter(): List<String> {
    val metricsParameter = mutableListOf<String>()
    val enableMetricsProvider = project.providers.gradleProperty("enableComposeCompilerMetrics")
    val enableMetrics = (enableMetricsProvider.orNull == "true")
    if (enableMetrics) {
        val metricsFolder = File(project.buildDir, "compose-metrics")
        metricsParameter.add("-P")
        metricsParameter.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=${metricsFolder.absolutePath}"
        )
    }
    val enableReportsProvider = project.providers.gradleProperty("enableComposeCompilerReports")
    val enableReports = (enableReportsProvider.orNull == "true")
    if (enableReports) {
        val reportsFolder = File(project.buildDir, "compose-reports")
        metricsParameter.add("-P")
        metricsParameter.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" + reportsFolder.absolutePath
        )
    }
    return metricsParameter.toList()
}