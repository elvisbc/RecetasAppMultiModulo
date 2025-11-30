package com.elvis.recetaskmpmulti

import android.app.Application
import com.elvis.recetaskmpmulti.di.initKoin
import org.koin.dsl.module

class AppReceta: Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin {
            it.modules(
                modules = module {
                    single { this@AppReceta.applicationContext }
                }
            )
        }
    }
}