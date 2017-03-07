package com.cobble.bot.plugins.core.commands

import com.cobble.bot.MonsterTruckBot
import com.cobble.bot.api.Command
import com.cobble.bot.core.CommandRegistry
import sx.blah.discord.handle.obj.IMessage
import sx.blah.discord.util.MessageBuilder

/**
  * The HelpCommand class, this implements the [[com.cobble.bot.api.Command]] trait.
  *
  * @author Cobbleopolis
  * @version 1.0.0
  * @since 1.0.0
  */
class HelpCommand extends Command {

    override val name: String = "mthelp"

    override val usageText: String = "[command]"

    private val helpSuffix: String = s"Use `!$name [command]` to get specific command help."

    override val helpText: String = "Provides a list of commands. " + helpSuffix

    override val briefHelpText: String = "Provides a list of commands."

    override def execute(message: IMessage, args: Array[String]): Unit = {
        val messageBuilder: MessageBuilder = new MessageBuilder(MonsterTruckBot.client)
        if (args.isEmpty) {
            messageBuilder.appendContent("Commands:\n")
            CommandRegistry.registry.foreach(kv => {
                messageBuilder.appendContent(s"\t\u2022 !${kv._1} - ${kv._2.briefHelpText}\n")
            })
            messageBuilder.appendContent("\n" + helpSuffix)
        } else {
            val maybeCommand: Option[Command] = CommandRegistry.registry.get(args.head)
            if (maybeCommand.isDefined) {
                val command: Command = maybeCommand.get
                messageBuilder.appendContent(s"`!${command.name}` Command:\n\n")
                    .appendContent(s"Usage:\n")
                    .appendContent(s"\t`!${command.name} ${command.usageText}`\n\n")
                    .appendContent(s"Description:\n")
                    .appendContent(s"\t${command.helpText}")
            } else
                messageBuilder.appendContent(s"Command `${args.head}` not found. Use `!$name` to see a full list of commands. " + helpSuffix)
        }
        messageBuilder.withChannel(MonsterTruckBot.client.getOrCreatePMChannel(message.getAuthor))
        messageBuilder.build()
    }

}
