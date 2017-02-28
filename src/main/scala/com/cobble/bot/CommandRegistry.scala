package com.cobble.bot

import com.cobble.bot.command.{Command, HelpCommand, PingCommand, SOSCommand}

/**
  * The object used to maintain the commands registered to the bot.
  */
object CommandRegistry {

    /**
      * A map linking the name of a [[command.Command]] to its [[command.Command]] object.
      */
    var registry: Map[String, Command] = Map[String, Command]()

    /**
      * An instance of the [[command.PingCommand]]
      */
    val pingCommand: PingCommand = new PingCommand

    /**
      * An instance of the [[command.HelpCommand]]
      */
    val helpCommand: HelpCommand = new HelpCommand

    /**
      * An instance of the [[command.SOSCommand]]
      */
    val sosCommand: SOSCommand = new SOSCommand

    /**
      * Registers all of the [[command.Command]]s for the bot.
      */
    def registerCommands(): Unit = {
        registerCommand(pingCommand)
        registerCommand(helpCommand)
        registerCommand(sosCommand)
    }

    /**
      * Registers a single [[command.Command]] for the bot.
      * @param command The [[command.Command]] instance to register.
      */
    def registerCommand(command: Command): Unit = {
        registry += command.name -> command
    }

}
