package com.cobble.bot

import com.cobble.bot.command.Command
import sx.blah.discord.api.events.EventSubscriber
import sx.blah.discord.handle.impl.events.{MessageReceivedEvent, ReadyEvent}

class BotEventListener {

    @EventSubscriber
    def onReadyEvent(event: ReadyEvent): Unit = {
        MonsterTruckBot.logger.info("Monster Truck Bot ready")
    }

    @EventSubscriber
    def onMessageReceivedEvent(event: MessageReceivedEvent): Unit = {
        if (event.getMessage.getContent.startsWith("!") && !event.getMessage.getAuthor.isBot) {
            val contentArray: Array[String] = event.getMessage.getContent.split(" ")
            val commandName: String = contentArray.head.substring(1)
            val commandOpt: Option[Command] = CommandRegistry.registry.get(commandName)
            if (commandOpt.isDefined)
                commandOpt.get.execute(event.getMessage, contentArray.tail)
            MonsterTruckBot.logger.debug("Executed com.cobble.bot.command: " + commandName)
        }
    }

}
