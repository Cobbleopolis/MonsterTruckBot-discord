package com.cobble.bot.command

import com.cobble.bot.{CommandRegistry, MonsterTruckBot}
import sx.blah.discord.handle.obj.IMessage
import sx.blah.discord.util.MessageBuilder

class HelpCommand extends Command {

    override val helpText: String = "!mthelp [command]"

    override def execute(message: IMessage, args: Array[String]): Unit = {
        val messageBuilder: MessageBuilder = new MessageBuilder(MonsterTruckBot.client)
        if(args.isEmpty){
            messageBuilder.appendContent("Commands:\n")
            CommandRegistry.registry.foreach(kv => {
                messageBuilder.appendContent(s"\u2022  !${kv._1}\n")
            })
        } else {
            val commandOpt: Option[Command] = CommandRegistry.registry.get(args.head)
            if (commandOpt.isDefined)
                messageBuilder.appendContent(commandOpt.get.helpText)
            else
                messageBuilder.appendContent(s"Command ${args.head} not found. Use the help command with out any arguments to see a list of commands.")
        }
        messageBuilder.withChannel(MonsterTruckBot.client.getOrCreatePMChannel(message.getAuthor))
        messageBuilder.build()
    }

}
