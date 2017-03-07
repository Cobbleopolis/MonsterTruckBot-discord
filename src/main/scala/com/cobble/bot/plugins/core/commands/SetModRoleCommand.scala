package com.cobble.bot.plugins.core.commands

import com.cobble.bot.api.Command
import com.cobble.bot.util.MessageUtil
import com.cobble.bot.util.db.CoreSettingsUtil
import sx.blah.discord.handle.obj.{IMessage, IRole}

import scala.collection.JavaConverters._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
  * The SetModRoleCommand class, this implements the [[com.cobble.bot.api.Command]] trait.
  *
  * This will set the mod role for the guild it is called in.
  *
  * @author Cobbleopolis
  * @version 1.0.0
  * @since 1.0.0
  */
class SetModRoleCommand extends Command {

    override val name: String = "setModRole"

    override val usageText: String = "<role_mention>"

    override val helpText: String = "Sets the mod role for the discord server"

    override val briefHelpText: String = helpText

    override def execute(message: IMessage, args: Array[String]): Unit = {
        val maybeModRole: Option[IRole] = message.getRoleMentions.asScala.headOption
        if (maybeModRole.isDefined) {
            val modRole = maybeModRole.get
            val setModRoleFuture = CoreSettingsUtil.setGuildModeratorRole(message.getGuild.getID, modRole.getID)
            setModRoleFuture.onComplete {
                case Success(numUpdated) =>
                    if (numUpdated == 1)
                        message.getChannel.sendMessage(MessageUtil.formatMessage(message.getAuthor.mention, s"Successfully set moderator to ${modRole.mention}"))
                    else if (numUpdated == 0)
                        message.getChannel.sendMessage(MessageUtil.formatMessage(message.getAuthor.mention, s"There was an issue setting the moderator role for this server. Perhaps this server's id is not in the database. So I don't know how you called this command..."))
                case Failure(t) =>
                    message.getChannel.sendMessage(MessageUtil.getErrorMessage(message.getAuthor.mention, s"There was an issue setting moderator to ${modRole.mention}", t))
            }
        } else {
            message.getChannel.sendMessage(MessageUtil.commandUsageError(message.getAuthor.mention, "Role mention not found.", name))
        }
    }

}
