package com.cobble.bot

import com.cobble.bot.core.PluginManager
import org.slf4j.{Logger, LoggerFactory}
import sx.blah.discord.api.events.EventDispatcher
import sx.blah.discord.api.{ClientBuilder, IDiscordClient}

/**
  * The main object of the Monster Truck Bot.
  *
  * @author Cobbleopolis
  * @version 1.0.0
  * @since 1.0.0
  */
object MonsterTruckBot {

    /**
      * Logged in client for the Monster Truck Bot.
      */
    lazy val client: IDiscordClient = clientBuilder.login()

    /**
      * Logger used by the Monster Truck Bot.
      */
    val logger: Logger = LoggerFactory.getLogger("Monster Truck Bot")

    /**
      * A builder used to make [[client]].
      */
    private val clientBuilder: ClientBuilder = new ClientBuilder()

    def main(args: Array[String]): Unit = {
        PluginManager.registerPlugins()
        clientBuilder.withToken(args(0))
        val dispatcher: EventDispatcher = client.getDispatcher
        dispatcher.registerListener(new BotEventListener)

    }

}
