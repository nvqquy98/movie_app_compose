plugins {
    `kotlin-dsl`
}

group = "com.dutkinght.moviedb.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.spotless.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "dutkinght.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidApplication") {
            id = "dutkinght.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidFeature") {
            id = "dutkinght.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }

        register("androidHiltCompose") {
            id = "dutkinght.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "dutkinght.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidLibrary") {
            id = "dutkinght.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("SpotlessConventionPlugin") {
            id = "dutkinght.spotless"
            implementationClass = "SpotlessConventionPlugin"
        }
    }
}