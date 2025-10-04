plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    namespace = "com.carlos.pokedex"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.carlos.pokedex"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // ✅ Correct groupId for CodePath AsyncHttpClient
    implementation("com.codepath.libraries:asynchttpclient:2.2.0")

    // Image loading
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // OkHttp (ensures Headers resolves even if transitives change)
    implementation("com.squareup.okhttp3:okhttp:4.10.0")

    // AndroidX
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}


