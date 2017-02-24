package com.cobble.bot

import org.slf4j.{Logger, LoggerFactory}
import sx.blah.discord.api.events.EventDispatcher
import sx.blah.discord.api.{ClientBuilder, IDiscordClient}

object MonsterTruckBot {

    val logger: Logger = LoggerFactory.getLogger("Monster Truck Bot")

    private val clientBuilder: ClientBuilder = new ClientBuilder()

    lazy val client: IDiscordClient = clientBuilder.login()

    def main(args: Array[String]): Unit = {
        CommandRegistry.registerCommands()
        clientBuilder.withToken(args(0))
        val dispatcher: EventDispatcher = client.getDispatcher
        dispatcher.registerListener(new BotEventListener)

    }

}
