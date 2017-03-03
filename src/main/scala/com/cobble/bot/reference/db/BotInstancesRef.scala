package com.cobble.bot.reference.db

import com.cobble.bot.db.Tables._
import slick.jdbc.PostgresProfile.api._
import slick.lifted.Compiled

object BotInstancesRef {

    /**
      * Compiled query that updates the mod role id for a [[com.cobble.bot.db.Tables#BotInstance]].
      */
    val updateModRoleId = Compiled(updateModRoleIdQuery _)

    /**
      * Compiled query that gets a [[com.cobble.bot.db.Tables#BotInstance]] by its guild id.
      */
    val getById = Compiled(getByIdQuery _)

    /**
      * A function query that updates the mod role id for a [[com.cobble.bot.db.Tables#BotInstance]].
      *
      * @param guildId The guild id of the [[com.cobble.bot.db.Tables#BotInstance]] to update the moderator role for.
      * @return A query that updates the mod role id for a guild.
      */
    private def updateModRoleIdQuery(guildId: Rep[String]): Query[Rep[Option[String]], Option[String], Seq] =
        for {
            botInstance <- BotInstances if botInstance.guildId === guildId
        } yield botInstance.moderatorRoleId

    /**
      * A function query that gets a [[com.cobble.bot.db.Tables#BotInstance]] by its guild id.
      *
      * @param guildId The guild id of the [[com.cobble.bot.db.Tables#BotInstance]] to get.
      * @return A query that gets a [[com.cobble.bot.db.Tables#BotInstance]] by its guild.
      */
    private def getByIdQuery(guildId: Rep[String]) = BotInstances.filter(_.guildId === guildId)
}
