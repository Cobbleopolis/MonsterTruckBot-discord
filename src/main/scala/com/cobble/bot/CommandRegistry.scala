package com.cobble.bot

import com.cobble.bot.command.{Command, HelpCommand, PingCommand}

object CommandRegistry {

    var registry: Map[String, Command] = Map[String, Command]()

    val pingCommand: PingCommand = new PingCommand

    val helpCommand: HelpCommand = new HelpCommand

    def registerCommands(): Unit = {
        registerCommand(pingCommand)
        registerCommand(helpCommand)
    }

    def registerCommand(command: Command): Unit = {
        registry += command.name -> command
    }

}
