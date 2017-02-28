package com.cobble.bot.command

import com.cobble.bot.MonsterTruckBot
import sx.blah.discord.handle.obj.{IGuild, IMessage}

import scala.collection.JavaConverters._

/**
  * The SOSCommand class, this implements the [[Command]] trait.
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
            message.getChannel.sendMessage("You can not send a sos from a direct message.")
        else {
            val guild: IGuild = message.getGuild
            val sosTextBuilder: StringBuilder = new StringBuilder(s"${message.getAuthor.mention} just sent an SOS from ${message.getChannel.mention}.")
            if (args.nonEmpty)
                sosTextBuilder.append(s"\n\t**SOS Message:** ${args.mkString(" ")}")
            val sosText: String = sosTextBuilder.toString
            //TODO fix so that it will get the moderator role for the guild rather than looking for any roles called "Moderator". Needs to setup config/settings first (Redis server?).
            guild.getRolesByName("Moderator").forEach(role => {
                guild.getUsersByRole(role).asScala.filterNot(_.isBot).foreach(user => {
                    MonsterTruckBot.client.getOrCreatePMChannel(user).sendMessage(sosText)
                })
            })
        }
    }

}
