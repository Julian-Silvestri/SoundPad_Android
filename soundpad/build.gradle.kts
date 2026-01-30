plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.silvestri.soundpad"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.silvestri.soundpad"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures{
        viewBinding = true
        dataBinding = true
    }

    dataBinding{
        enable = true
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.navigation.ui)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment)
    implementation(libs.appcompat.v7)
    implementation(libs.constraint.layout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.navigation)
    testImplementation(libs.junit)
    androidTestImplementation(libs.runner)
    androidTestImplementation(libs.espresso.core)
}