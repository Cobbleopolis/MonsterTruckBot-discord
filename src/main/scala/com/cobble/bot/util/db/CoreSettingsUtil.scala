package com.cobble.bot.util.db

import com.cobble.bot.db.Tables._
import com.cobble.bot.reference.db.CoreSettingsRef
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

object CoreSettingsUtil {

    def getCoreSettingsById(guildId: String): Future[Option[CoreSettingsRow]] = {
        db.run(
            CoreSettingsRef.getById(guildId).result.headOption
        )
    }

    /**
      * Updates a guild's moderator role
      *
      * @param guildId         The id of the guild to update the moderator role for.
      * @param moderatorRoleId The id of the new moderator role for the guild.
      * @return A [[scala.concurrent.Future]] that returns an int of how many rows were updating. Should either be `1` or `0`.
      */
    def setGuildModeratorRole(guildId: String, moderatorRoleId: String): Future[Int] = {
        db.run(
            CoreSettings.insertOrUpdate(CoreSettingsRow(guildId, moderatorRoleId = Some(moderatorRoleId)))
        )
    }

}
