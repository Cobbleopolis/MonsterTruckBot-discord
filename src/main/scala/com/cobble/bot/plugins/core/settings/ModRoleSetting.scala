package com.cobble.bot.plugins.core.settings

import com.cobble.bot.api.Setting
import com.cobble.bot.util.db.CoreSettingsUtil
import sx.blah.discord.handle.obj.IMessage

import scala.collection.JavaConverters._
import scala.concurrent.Future

class ModRoleSetting extends Setting[String] {

    override val key: String = "modRole"

    override def extractValue(message: IMessage, args: Array[String]): Option[String] = {
        message.getRoleMentions.asScala.map(role => role.getID).headOption
    }

    override def setValue(guildId: String, value: String): Future[Int] = CoreSettingsUtil.setGuildModeratorRole(guildId, value)
}
