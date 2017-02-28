package com.cobble.bot.command

import sx.blah.discord.handle.obj.{IMessage, IUser}

import scala.collection.JavaConverters._
import scala.collection.mutable

/**
  * The PingCommand class, this implements the [[Command]] class.
  */
class PingCommand extends Command {

    override val name: String = "ping"

    override val usageText: String = "[username_mentions...]"

    override val helpText: String = "A simple command to ping the bot to make sure it is alive."

    override val briefHelpText: String = helpText

    override def execute(message: IMessage, args: Array[String]): Unit = {
        val mentions: mutable.Buffer[IUser] = message.getMentions.asScala
        if (mentions.nonEmpty)
            mentions.foreach(user => message.getChannel.sendMessage(s"pong ${user.mention}"))
        else
            message.getChannel.sendMessage(s"pong!")
    }

}
