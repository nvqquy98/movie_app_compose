plugins {
    alias(libs.plugins.dutkinght.android.application)
    alias(libs.plugins.dutkinght.android.hilt)
    alias(libs.plugins.dutkinght.android.firebase)
    alias(libs.plugins.dutkinght.spotless)
}

android {
    namespace = "com.dutkinght.core.firestore"
}
