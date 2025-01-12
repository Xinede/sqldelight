package com.example

import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.JdbcPreparedStatement
import kotlin.Int
import kotlin.Long
import kotlin.String

public class DataQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun insertFirst(first: Long) {
    driver.execute(-2_134_278_654, """INSERT INTO test_1 (first) VALUES (?)""", 1) {
          check(this is JdbcPreparedStatement)
          bindLong(0, first)
        }
    notifyQueries(-2_134_278_654) { emit ->
      emit("test_1")
    }
  }

  public fun insertSecond(
    first: String?,
    second: Int,
    third: String,
    fourth: Int?,
    fifth: Long?,
  ) {
    driver.execute(-1_370_094_750,
        """INSERT INTO test_2 (first, second, third, fourth, fifth) VALUES (?, ?, ?, ?, ?)""", 5) {
          check(this is JdbcPreparedStatement)
          bindString(0, first)
          bindInt(1, second)
          bindString(2, third)
          bindInt(3, fourth)
          bindLong(4, fifth)
        }
    notifyQueries(-1_370_094_750) { emit ->
      emit("test_2")
    }
  }
}
