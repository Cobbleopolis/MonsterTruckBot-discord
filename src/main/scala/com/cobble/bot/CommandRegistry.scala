package com.cobble.bot

import com.cobble.bot.command.{Command, HelpCommand, PingCommand}

object CommandRegistry {

    var registry: Map[String, Command] = Map[String, Command]()

    def registerCommands(): Unit = {
        registry ++= Seq(
            "ping" -> new PingCommand,
            "mthelp" -> new HelpCommand
        )
    }

}
