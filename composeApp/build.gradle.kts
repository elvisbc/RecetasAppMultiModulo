

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.androidKmpLibrary)
    alias(libs.plugins.composeHotReload)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    androidLibrary {
        compileSdk = 36
        minSdk = 24
        namespace = "com.elvis.recetaskmpmulti"
        experimentalProperties["android.experimental.kmp.enableAndroidResources"] = true
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
            //sqldelight
            implementation(libs.sql.delight.android)
        }
        commonMain.dependencies {

            implementation(projects.comun.navegacion)

            implementation(projects.coreNetwork)
            implementation(projects.coreBaseDatos)
            implementation(projects.coreNavegacion)

            implementation(projects.receta.data)
            implementation(projects.receta.dominio)
            implementation(projects.receta.ui)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            //navegacion
            implementation(libs.navigation.compose)
            //implementation(libs.jetbrains.navigation3.ui)
            //implementation(libs.jetbrains.lifecycle.viewModel.nav3)
            //koin
            implementation(libs.koin.core)
            //serialization
            implementation(libs.kotlinx.serialization.json)
            //sqldelight
            implementation(libs.sql.delight.common)
            api(libs.sql.delight.common.coroutines)
            //iconos
            implementation(compose.materialIconsExtended)

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)

            //sqldelight
            implementation(libs.sql.delight.common.desktop)

        }
    }
}

/*compose.desktop {
    application {
        mainClass = "com.elvis.recetaskmpmulti.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.elvis.recetaskmpmulti"
            packageVersion = "1.0.0"
        }
    }
}*/
