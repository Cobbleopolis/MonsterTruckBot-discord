package com.cobble.bot.util

import com.cobble.bot.db.Tables
import com.cobble.bot.db.Tables._
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

object DBUtil {

    val db: _root_.slick.jdbc.PostgresProfile.backend.DatabaseDef = Database.forConfig("mtrBotDB")

    /**
      * Batch inserts [[BotInstance]]s.
      *
      * @param botInstances The [[BotInstance]]s to insert.
      * @return A [[Future]] that inserts the passed [[BotInstance]]s.
      */
    def insertBotInstances(botInstances: BotInstance*): Future[Unit] = {
        db.run(DBIO.seq(
            Tables.BotInstances ++= botInstances
        ))
    }

}
