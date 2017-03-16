package com.cobble.bot.plugins.core.commands

import com.cobble.bot.api.Command
import sx.blah.discord.handle.obj.IMessage

/**
  * The ConfigCommand class, this implements the [[com.cobble.bot.api.Command]] trait.
  *
  * @author Cobbleopolis
  * @version 1.0.0
  * @since 1.0.0
  */
class ConfigCommand extends Command {

    override val name: String = "config"

    override val usageText: String = "<configKey> <configValue>"

    override val helpText: String = "This command sets a specified setting key to a provided value assuming the user has the correct permission."

    override val briefHelpText: String = "Sets config values."

    override def execute(message: IMessage, args: Array[String]): Unit = {

    }
}
