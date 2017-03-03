package com.cobble.bot.util

import com.cobble.bot.db.Tables._
import com.cobble.bot.reference.db.BotInstancesRef
import slick.jdbc.PostgresProfile.api._
import sx.blah.discord.handle.obj.IRole

import scala.concurrent.Future

object DBUtil {

    /**
      * Database using the provided config.
      */
    val db: _root_.slick.jdbc.PostgresProfile.backend.DatabaseDef = Database.forConfig("mtrBotDB")

    /**
      * Batch inserts [[com.cobble.bot.db.Tables#BotInstance]]s.
      *
      * @param botInstances The [[com.cobble.bot.db.Tables#BotInstance]]s to insert.
      * @return A [[scala.concurrent.Future]] that inserts the passed [[com.cobble.bot.db.Tables#BotInstance]]s.
      */
    def insertBotInstances(botInstances: BotInstance*): Future[Option[Int]] = {
        db.run(
            BotInstances ++= botInstances
        )
    }

    /**
      * Updates a guild's moderator role
      *
      * @param guildId       The id of the guild to update the moderator role for.
      * @param moderatorRole The new moderator role for the guild.
      * @return A [[scala.concurrent.Future]] that returns an int of how many rows were updating. Should either be `1` or `0`.
      */
    def setGuildModeratorRole(guildId: String, moderatorRole: IRole): Future[Int] = {
        db.run(
            BotInstancesRef.updateModRoleId(guildId).update(Some(moderatorRole.getID))
        )
    }

    /**
      * Gets a guild from its id.
      *
      * @param guildId The id of the guild to get.
      * @return A [[scala.concurrent.Future]] that optionally returns an [[com.cobble.bot.db.Tables#BotInstance]] that has the provided id. If the provided id does not match any entries [[scala.None]] is returned.
      */
    def getBotInstanceById(guildId: String): Future[Option[BotInstance]] = {
        db.run(
            BotInstancesRef.getById(guildId).result.headOption
        )
    }

}
