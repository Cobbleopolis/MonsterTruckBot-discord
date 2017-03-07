package com.cobble.bot.core

import com.cobble.bot.api.Command

/**
  * The object used to maintain the commands registered to the bot.
  *
  * @author Cobbleopolis
  * @version 1.0.0
  * @since 1.0.0
  */
object CommandRegistry {

    /**
      * A map linking the name of a [[com.cobble.bot.api.Command]] to its [[com.cobble.bot.api.Command]] object.
      */
    var registry: Map[String, Command] = Map[String, Command]()


    /**
      * Registers all of the [[com.cobble.bot.api.Command]]s for the bot.
      */
    def registerCommands(): Unit = {

    }

    /**
      * Registers a single [[com.cobble.bot.api.Command]] for the bot.
      *
      * @param command The [[com.cobble.bot.api.Command]] instance to register.
      */
    def registerCommand(command: Command): Unit = {
        registry += command.name -> command
    }

}
