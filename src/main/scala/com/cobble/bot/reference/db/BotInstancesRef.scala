package com.cobble.bot.reference.db

import com.cobble.bot.db.Tables._
import slick.jdbc.PostgresProfile.api._
import slick.lifted.Compiled

object BotInstancesRef {

    val updateModRoleId = Compiled(updateModRoleIdQuery _)
    val getById = Compiled(getByIdQuery _)

    private def updateModRoleIdQuery(guildId: Rep[String]): Query[Rep[Option[String]], Option[String], Seq] =
        for {
            botInstance <- BotInstances if botInstance.guildId === guildId
        } yield botInstance.moderatorRoleId

    private def getByIdQuery(guildId: Rep[String]) = BotInstances.filter(_.guildId === guildId)
}
