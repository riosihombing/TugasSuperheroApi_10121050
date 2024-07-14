/*
 * Project Name : TugasSuperheroAPI_10121050
 * Created by Rio
 * Copyright (c) 2024. All rights reserverd.
 * Last modified 7/14/24, 2:50 PM
 */
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.rio.tugassuperheroapi_10121050"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.rio.tugassuperheroapi_10121050"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        enable = true
    }
    dataBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation (libs.androidx.core.ktx.v1101)
    implementation (libs.androidx.appcompat.v161)
    implementation (libs.material.v190)
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //Picasso
    implementation ("com.squareup.picasso:picasso:2.8")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation (libs.androidx.junit.v115)
    androidTestImplementation (libs.androidx.espresso.core.v351)
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation ("com.google.code.gson:gson:2.10")
}