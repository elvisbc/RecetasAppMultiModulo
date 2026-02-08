import com.android.build.api.dsl.LibraryExtension
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    alias(libs.plugins.sql.delight)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    jvm()
    
    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            //sqlight
            implementation(libs.sql.delight.android)
        }
        commonMain.dependencies {
            //koin
            implementation(libs.koin.core)
            //sqldelight
            implementation(libs.sql.delight.common)
            api(libs.sql.delight.common.coroutines)


        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
            //ktor desktop
            implementation(libs.ktor.client.cio)
            //sqldelight
            implementation(libs.sql.delight.common.desktop)
        }
        iosMain.dependencies {
            //ktor ios
            implementation(libs.ktor.client.darwin)
            //sqldelight
            implementation(libs.sql.delight.common.ios)
        }
    }
}
sqldelight {
    databases{
        create("AppBaseDatos"){
            packageName.set("com.elvis.coreBaseDatos")
            srcDirs("src/commonMain/sqldelight")
        }
    }
}
android {
    namespace = "com.elvis.androidApp"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

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
    buildFeatures {
        compose = true
    }
}

/*compose.desktop {
    application {

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.elvis.corebaseDatos"
            packageVersion = "1.0.0"
        }
    }
}*/
