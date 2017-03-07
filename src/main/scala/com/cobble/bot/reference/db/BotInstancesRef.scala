package com.cobble.bot.reference.db

import com.cobble.bot.db.Tables._
import slick.jdbc.PostgresProfile.api._
import slick.lifted.Compiled

object BotInstancesRef {

    /**
      * Compiled query that gets a [[com.cobble.bot.db.Tables#BotInstancesRow]] by its guild id.
      */
    val getById = Compiled(getByIdQuery _)

    /**
      * A function query that gets a [[com.cobble.bot.db.Tables#BotInstancesRow]] by its guild id.
      *
      * @param guildId The guild id of the [[com.cobble.bot.db.Tables#BotInstancesRow]] to get.
      * @return A query that gets a [[com.cobble.bot.db.Tables#BotInstancesRow]] by its guild.
      */
    private def getByIdQuery(guildId: Rep[String]) = BotInstances.filter(_.guildId === guildId)
}
