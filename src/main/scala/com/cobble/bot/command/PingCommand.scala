package com.cobble.bot.command

import sx.blah.discord.handle.obj.{IMessage, IUser}

import scala.collection.JavaConverters._
import scala.collection.mutable

class PingCommand extends Command {

    val helpText: String = "!ping [username_mentions...]"

    override def execute(message: IMessage, args: Array[String]): Unit = {
        val mentions: mutable.Buffer[IUser] = message.getMentions.asScala
        if (mentions.nonEmpty)
            mentions.foreach(user => message.getChannel.sendMessage(s"pong ${user.mention}"))
        else
            message.getChannel.sendMessage(s"pong!")
    }

}
