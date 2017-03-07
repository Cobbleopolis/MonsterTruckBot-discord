package com.cobble.bot.reference.db

import com.cobble.bot.db.Tables.CoreSettings
import slick.jdbc.PostgresProfile.api._
import slick.lifted.Compiled

object CoreSettingsRef {

    /**
      * Compiled query that gets a [[com.cobble.bot.db.Tables#CoreSettingsRow]] by its guild id.
      */
    val getById = Compiled(getByIdQuery _)

    /**
      * Compiled query that updates the mod role id for a [[com.cobble.bot.db.Tables#CoreSettingsRow]].
      */
    val updateModRoleId = Compiled(updateModRoleIdQuery _)


    /**
      * A function query that gets a [[com.cobble.bot.db.Tables#CoreSettingsRow]] by its guild id.
      *
      * @param guildId The guild id of the [[com.cobble.bot.db.Tables#CoreSettingsRow]] to get.
      * @return A query that gets a [[com.cobble.bot.db.Tables#CoreSettingsRow]] by its guild.
      */
    private def getByIdQuery(guildId: Rep[String]) = CoreSettings.filter(_.guildId === guildId)

    /**
      * A function query that updates the mod role id for a [[com.cobble.bot.db.Tables#CoreSettingsRow]].
      *
      * @param guildId The guild id of the [[com.cobble.bot.db.Tables#CoreSettingsRow]] to update the moderator role for.
      * @return A query that updates the mod role id for a guild.
      */
    private def updateModRoleIdQuery(guildId: Rep[String]): Query[Rep[Option[String]], Option[String], Seq] =
        for {
            coreSettings <- CoreSettings if coreSettings.guildId === guildId
        } yield coreSettings.moderatorRoleId

}
