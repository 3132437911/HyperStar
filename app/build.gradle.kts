import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.chaos.hyperstar"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.chaos.hyperstar"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    android.applicationVariants.all {
        outputs.all {
            if (this is com.android.build.gradle.internal.api.ApkVariantOutputImpl) {
                val config = project.android.defaultConfig
                val appName = "HyperStar"
                val versionName = "v"+config.versionName
                val formatter = DateTimeFormatter.ofPattern("yyyyMMddHH")
                val createTime = LocalDateTime.now().format(formatter)
                this.outputFileName = "${appName}_${versionName}_${createTime}_test.apk"
            }
        }
    }

//    android.applicationVariants.all { variant ->
//        variant.outputs.all { output ->
//            val fileName = "HyperStar-${variant.name}-v${variant.versionName}.apk"
//
//            output.outputFile.renameTo(File(output.outputFile.parent, fileName))
//            output.outputFile.renameTo("HyperStar-${variant.name}-v${variant.versionName}.apk")
//        }
//    }



    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

        }

        debug {
            // 对于debug版本，可以不使用混淆和资源压缩
            isMinifyEnabled = false
            isShrinkResources = false

        }
    }
    //outputFileName = "${defaultConfig.applicationId}${buildType.applicationIdSuffix}-${defaultConfig.versionName}${buildType.versionNameSuffix}.apk"
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    //implementation (libs.core)
    implementation ("com.google.accompanist:accompanist-drawablepainter:0.35.2-beta")
    implementation (libs.androidx.recyclerview)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.constraintlayout)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    compileOnly (libs.android.xposed)
    //implementation(libs.ezxhelper)
    implementation("com.github.kyuubiran:EzXHelper:2.0.8")
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation (libs.miuix)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    //implementation(libs.androidx.ui)
//    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
//    androidTestImplementation(libs.androidx.ui.test.junit4)
//    debugImplementation(libs.androidx.ui.tooling)
//    debugImplementation(libs.androidx.ui.test.manifest)
}