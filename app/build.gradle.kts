plugins {
    alias(libs.plugins.dutkinght.android.application)
    alias(libs.plugins.dutkinght.android.application.compose)
    alias(libs.plugins.dutkinght.android.hilt)
    alias(libs.plugins.dutkinght.android.firebase)
    alias(libs.plugins.dutkinght.spotless)
}

android {
    namespace = "com.dutkinght.moviedbapp"
    compileSdk = Configurations.compileSdk

    defaultConfig {
        applicationId = "com.dutkinght.moviedbapp"
        minSdk = Configurations.minSdk
        targetSdk = Configurations.targetSdk
        versionCode = Configurations.versionCode
        versionName = Configurations.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.ktx)

    // compose
    implementation(libs.androidx.activty.compose)

    // jetpack
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)

    testImplementation(libs.junit.test)
    androidTestImplementation(libs.junit.ext)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ui.test.junit)
    debugImplementation(libs.ui.test.manifest)
}