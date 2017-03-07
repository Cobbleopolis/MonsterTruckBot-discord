package com.cobble.bot.plugins.core.commands

import com.cobble.bot.MonsterTruckBot
import com.cobble.bot.api.Command
import com.cobble.bot.util.MessageUtil
import com.cobble.bot.util.db.CoreSettingsUtil
import sx.blah.discord.handle.obj.{IGuild, IMessage, IUser}

import scala.collection.JavaConverters._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
  * The SOSCommand class, this implements the [[Command]] trait.
  *
  * @author Cobbleopolis
  * @version 1.0.0
  * @since 1.0.0
  */
class SOSCommand extends Command {

    override val name: String = "sos"

    override val usageText: String = "[message]"

    override val helpText: String = "Sends an SOS to the moderators with a message if provided."

    override val briefHelpText: String = "Quickly notifies the moderators on the server."

    override def execute(message: IMessage, args: Array[String]): Unit = {
        if (message.getChannel.isPrivate)
            message.getChannel.sendMessage("You can not send a SOS from a direct message.")
        else {
            message.delete()
            val guild: IGuild = message.getGuild
            val author: IUser = message.getAuthor
            val sosTextBuilder: StringBuilder = new StringBuilder(s"${author.mention} just sent an SOS from ${message.getChannel.mention}.")
            if (args.nonEmpty)
                sosTextBuilder.append(s"\n\t**SOS Message:** ${args.mkString(" ")}")
            val sosText: String = sosTextBuilder.toString
            CoreSettingsUtil.getCoreSettingsById(guild.getID).onComplete {
                case Success(maybeBotInstance) =>
                    if (maybeBotInstance.isDefined) {
                        val maybeModeratorRoleId: Option[String] = maybeBotInstance.get.moderatorRoleId
                        if (maybeModeratorRoleId.isDefined) {
                            guild.getUsersByRole(guild.getRoleByID(maybeModeratorRoleId.get)).asScala.filterNot(_.isBot).foreach(user => {
                                MonsterTruckBot.client.getOrCreatePMChannel(user).sendMessage(sosText)
                            })
                            author.getOrCreatePMChannel.sendMessage("SOS successfully sent to the moderators.")
                        } else
                            author.getOrCreatePMChannel.sendMessage("No moderator role is set for this server. Please ask your mods to set one.")
                    } else
                        author.getOrCreatePMChannel.sendMessage(MessageUtil.formatMessage(author.mention, " This server is not found in the database. I don't know how you called this command..."))
                case Failure(t) =>
                    author.getOrCreatePMChannel.sendMessage(MessageUtil.getErrorMessage(author.mention, "There was an issue sending the SOS.", t))
            }
        }
    }

}
