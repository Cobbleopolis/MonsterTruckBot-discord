package com.cobble.bot.plugins.core.commands

import com.cobble.bot.api.Command
import com.cobble.bot.util.MessageUtil
import sx.blah.discord.handle.obj.IMessage

/**
  * The PingCommand class, this implements the [[com.cobble.bot.api.Command]] trait.
  *
  * @author Cobbleopolis
  * @version 1.0.0
  * @since 1.0.0
  */
class PingCommand extends Command {

    override val name: String = "ping"

    override val usageText: String = ""

    override val helpText: String = "A simple command to ping the bot to make sure it is alive."

    override val briefHelpText: String = helpText

    override def execute(message: IMessage, args: Array[String]): Unit = {
        message.getChannel.sendMessage(MessageUtil.formatMessage(message.getAuthor.mention, "pong!"))
    }

}
