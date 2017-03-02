package com.cobble.bot.util

import com.cobble.bot.db.Tables._
import com.cobble.bot.reference.db.BotInstancesRef
import slick.jdbc.PostgresProfile.api._
import sx.blah.discord.handle.obj.IRole

import scala.concurrent.Future

object DBUtil {

    val db: _root_.slick.jdbc.PostgresProfile.backend.DatabaseDef = Database.forConfig("mtrBotDB")

    /**
      * Batch inserts [[BotInstance]]s.
      *
      * @param botInstances The [[BotInstance]]s to insert.
      * @return A [[Future]] that inserts the passed [[BotInstance]]s.
      */
    def insertBotInstances(botInstances: BotInstance*): Future[Option[Int]] = {
        db.run(
            BotInstances ++= botInstances
        )
    }

    def setGuildModeratorRole(guildId: String, moderatorRole: IRole): Future[Int] = {
        db.run(
            BotInstancesRef.updateModRoleId(guildId).update(Some(moderatorRole.getID))
        )
    }

    def getBotInstanceById(guildId: String): Future[Option[BotInstance]] = {
        db.run(
            BotInstancesRef.getById(guildId).result.headOption
        )
    }

}
