package com.cobble.bot.plugins.core

import com.cobble.bot.api.{Command, Plugin}
import com.cobble.bot.plugins.core.commands.{HelpCommand, PingCommand, SOSCommand, SetModRoleCommand}

class CorePlugin extends Plugin {

    val name: String = "core"

    val displayName: String = "Core"

    val commands: Seq[Command] = Seq(
        CorePlugin.pingCommand,
        CorePlugin.helpCommand,
        CorePlugin.sosCommand,
        CorePlugin.setModRoleCommand
    )

}

object CorePlugin {

    /**
      * An instance of the [[commands.PingCommand]]
      */
    val pingCommand: PingCommand = new PingCommand

    /**
      * An instance of the [[commands.HelpCommand]]
      */
    val helpCommand: HelpCommand = new HelpCommand

    /**
      * An instance of the [[commands.SOSCommand]]
      */
    val sosCommand: SOSCommand = new SOSCommand

    /**
      * An instance of the [[commands.SetModRoleCommand]]
      */
    val setModRoleCommand: SetModRoleCommand = new SetModRoleCommand
}
