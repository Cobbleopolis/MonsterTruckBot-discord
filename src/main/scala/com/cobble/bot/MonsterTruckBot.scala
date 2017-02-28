package com.cobble.bot

import org.slf4j.{Logger, LoggerFactory}
import sx.blah.discord.api.events.EventDispatcher
import sx.blah.discord.api.{ClientBuilder, IDiscordClient}

/**
  * The main object of the Monster Truck Bot.
  * @author Cobbleopolis
  * @version 1.0.0
  * @since 1.0.0
  */
object MonsterTruckBot {

    /**
      * Logger used by the Monster Truck Bot.
      */
    val logger: Logger = LoggerFactory.getLogger("Monster Truck Bot")

    /**
      * A builder used to make [[client]].
      */
    private val clientBuilder: ClientBuilder = new ClientBuilder()

    /**
      * Logged in client for the Monster Truck Bot.
      */
    lazy val client: IDiscordClient = clientBuilder.login()

    def main(args: Array[String]): Unit = {
        CommandRegistry.registerCommands()
        clientBuilder.withToken(args(0))
        val dispatcher: EventDispatcher = client.getDispatcher
        dispatcher.registerListener(new BotEventListener)

    }

}
