plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    id("com.google.dagger.hilt.android") version "2.46.1" apply false
    alias(libs.plugins.androidLibrary) apply false
}
true