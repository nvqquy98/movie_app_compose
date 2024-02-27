plugins {
    id("dutkinght.android.application")
    id("dutkinght.android.application.compose")
    id("dutkinght.android.hilt")
    id("com.google.devtools.ksp")
    id("dutkinght.spotless")
}

android {
    namespace = "com.dutkinght.feature.welcome"
}

dependencies {
    testImplementation(libs.junit.test)
    androidTestImplementation(libs.junit.ext)
    androidTestImplementation(libs.espresso.core)
}