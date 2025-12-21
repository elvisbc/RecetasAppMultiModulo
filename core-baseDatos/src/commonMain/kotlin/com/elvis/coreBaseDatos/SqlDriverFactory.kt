package com.elvis.coreBaseDatos

import app.cash.sqldelight.db.SqlDriver

expect class SqlDriverFactory(context: Any ? = null) {
    fun obtenerDriverSql(): SqlDriver
}