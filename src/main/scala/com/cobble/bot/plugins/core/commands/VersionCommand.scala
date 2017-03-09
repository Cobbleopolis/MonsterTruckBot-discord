package com.cobble.bot.plugins.core.commands

import buildinfo.BuildInfo
import com.cobble.bot.api.Command
import com.cobble.bot.util.MessageUtil
import sx.blah.discord.handle.obj.IMessage

/**
  * The VersionCommand class, this implements the [[com.cobble.bot.api.Command]] trait.
  *
  * @author Cobbleopolis
  * @version 1.0.0
  * @since 1.0.0
  */
class VersionCommand extends Command {

    override val name: String = "version"

    override val usageText: String = ""

    override val helpText: String = "Displays the version of the bot"

    override val briefHelpText: String = "This will display the version of the bot in the channel that called it."

    override def execute(message: IMessage, args: Array[String]): Unit = {
        message.getChannel.sendMessage(MessageUtil.formatMessage(message.getAuthor.mention, s"Currently running version ${BuildInfo.version}"))
    }
}