package com.elvis.coreBaseDatos.di

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import com.elvis.coreBaseDatos.AppBaseDatos
import com.elvis.coreBaseDatos.SqlDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun obtenerModuloCoreBaseDatos(): Module {
    return module {
        single { SqlDriverFactory(get<Context>()).obtenerDriverSql() }
        single { AppBaseDatos.invoke(get<SqlDriver>()) }
    }
}