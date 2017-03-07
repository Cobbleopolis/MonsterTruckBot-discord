package com.cobble.bot.util.db

import com.cobble.bot.db.Tables.{BotInstances, BotInstancesRow}
import com.cobble.bot.reference.db.BotInstancesRef
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

object BotInstanceUtil {

    /**
      * Gets a guild from its id.
      *
      * @param guildId The id of the guild to get.
      * @return A [[scala.concurrent.Future]] that optionally returns an [[com.cobble.bot.db.Tables#BotInstancesRow]] that has the provided id. If the provided id does not match any entries [[scala.None]] is returned.
      */
    def getBotInstanceById(guildId: String): Future[Option[BotInstancesRow]] = {
        db.run(
            BotInstancesRef.getById(guildId).result.headOption
        )
    }

    /**
      * Batch inserts [[com.cobble.bot.db.Tables#BotInstancesRow]]s.
      *
      * @param botInstances The [[com.cobble.bot.db.Tables#BotInstancesRow]]s to insert.
      * @return A [[scala.concurrent.Future]] that inserts the passed [[com.cobble.bot.db.Tables#BotInstancesRow]]s.
      */
    def insertBotInstances(botInstances: BotInstancesRow*): Future[Option[Int]] = {
        db.run(
            BotInstances ++= botInstances
        )
    }

}
