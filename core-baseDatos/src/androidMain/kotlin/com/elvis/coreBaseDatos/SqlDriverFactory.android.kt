package com.elvis.coreBaseDatos

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

actual class SqlDriverFactory actual constructor(context: Any?) {
    private val context = context as Context


    actual fun obtenerDriverSql(): SqlDriver {
        return AndroidSqliteDriver(
            schema = AppBaseDatos.Schema,
            context = context,
            name = "Recetas.db"

        )
    }
}

/**
 * si no logra generarse AppBaseDatos
 * ./gradlew :core-baseDatos:generateSqlDelightInterface
 */