package com.cobble.bot

import com.cobble.bot.api.Command
import com.cobble.bot.core.CommandRegistry
import com.cobble.bot.db.Tables.BotInstancesRow
import com.cobble.bot.util.db.BotInstanceUtil
import sx.blah.discord.api.events.EventSubscriber
import sx.blah.discord.handle.impl.events.{MessageReceivedEvent, ReadyEvent}

import scala.collection.JavaConverters._


/**
  * A class used to listen for events sent by the bot.
  *
  * @author Cobbleopolis
  * @version 1.0.0
  * @since 1.0.0
  */
class BotEventListener {

    @EventSubscriber
    def onReadyEvent(event: ReadyEvent): Unit = {
        MonsterTruckBot.logger.info("Monster Truck Bot ready")
        BotInstanceUtil.insertBotInstances(MonsterTruckBot.client.getGuilds.asScala.map(guild => BotInstancesRow(guild.getID)): _*)
    }

    @EventSubscriber
    def onMessageReceivedEvent(event: MessageReceivedEvent): Unit = {
        if (event.getMessage.getContent.startsWith("!") && !event.getMessage.getAuthor.isBot) {
            val contentArray: Array[String] = event.getMessage.getContent.split(" ")
            val commandName: String = contentArray.head.substring(1)
            val maybeCommand: Option[Command] = CommandRegistry.registry.get(commandName)
            if (maybeCommand.isDefined) {
                maybeCommand.get.execute(event.getMessage, contentArray.tail)
                MonsterTruckBot.logger.debug("Executed com.cobble.bot.command: " + commandName)
            }
        }
    }

}
