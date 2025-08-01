plugins {
   alias(libs.plugins.android.application)
   alias(libs.plugins.kotlin.android)
}

android {
   namespace = "ca.georgiancollege.moviesearchapp"
   compileSdk = 35

   defaultConfig {
      applicationId = "ca.georgiancollege.moviesearchapp"
      minSdk = 24
      targetSdk = 35
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
      sourceCompatibility = JavaVersion.VERSION_11
      targetCompatibility = JavaVersion.VERSION_11
   }
   kotlinOptions {
      jvmTarget = "11"
   }
   viewBinding {
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
}
dependencies {
   implementation("androidx.recyclerview:recyclerview:1.4.0")
   implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
   implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
   implementation("com.squareup.okhttp3:okhttp:4.12.0")
   implementation("com.squareup.picasso:picasso:2.8")
   implementation("com.google.code.gson:gson:2.10.1")
}