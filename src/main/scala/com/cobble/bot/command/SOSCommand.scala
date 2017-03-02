package com.cobble.bot.command

import com.cobble.bot.MonsterTruckBot
import com.cobble.bot.util.{DBUtil, MessageUtil}
import sx.blah.discord.handle.obj.{IGuild, IMessage}

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
            val guild: IGuild = message.getGuild
            val sosTextBuilder: StringBuilder = new StringBuilder(s"${message.getAuthor.mention} just sent an SOS from ${message.getChannel.mention}.")
            if (args.nonEmpty)
                sosTextBuilder.append(s"\n\t**SOS Message:** ${args.mkString(" ")}")
            val sosText: String = sosTextBuilder.toString
            DBUtil.getBotInstanceById(guild.getID).onComplete {
                case Success(maybeBotInstance) =>
                    if (maybeBotInstance.isDefined) {
                        val maybeModeratorRoleId: Option[String] = maybeBotInstance.get.moderatorRoleId
                        if (maybeModeratorRoleId.isDefined)
                            guild.getUsersByRole(guild.getRoleByID(maybeModeratorRoleId.get)).asScala.filterNot(_.isBot).foreach(user => {
                                MonsterTruckBot.client.getOrCreatePMChannel(user).sendMessage(sosText)
                            })
                        else
                            message.getAuthor.getOrCreatePMChannel().sendMessage("No moderator role is set for this server. Please ask your mods to set one.")
                    } else
                        message.getChannel.sendMessage(MessageUtil.formatMessage(message.getAuthor.mention, " This server is not found in the database. I don't know how you called this command..."))
                case Failure(t) =>
                    message.getChannel.sendMessage(MessageUtil.getErrorMessage(message.getAuthor.mention, "There was an issue sending the SOS.", t))
            }
        }
    }

}
