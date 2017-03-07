package com.cobble.bot.util

import slick.jdbc.PostgresProfile.api._

package object db {

    /**
      * Database using the provided config.
      */
    val db: _root_.slick.jdbc.PostgresProfile.backend.DatabaseDef = Database.forConfig("mtrBotDB")

}
