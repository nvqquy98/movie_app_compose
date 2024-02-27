plugins {
    id("dutkinght.android.application")
    id("dutkinght.android.application.compose")
    id("dutkinght.android.hilt")
    id("com.google.devtools.ksp")
    id("dutkinght.spotless")
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
    ksp(libs.hilt.android.compiler)

    testImplementation(libs.junit.test)
    androidTestImplementation(libs.junit.ext)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ui.test.junit)
    debugImplementation(libs.ui.test.manifest)
}