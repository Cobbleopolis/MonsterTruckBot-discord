package com.cobble.bot.plugins.core

import com.cobble.bot.api.{Command, Plugin, Setting}
import com.cobble.bot.plugins.core.commands._
import com.cobble.bot.plugins.core.settings.ModRoleSetting

import scala.concurrent.Future

class CorePlugin extends Plugin {

    val name: String = "core"

    val displayName: String = "Core"

    val commands: Seq[Command] = Seq(
        CorePlugin.versionCommand,
        CorePlugin.pingCommand,
        CorePlugin.helpCommand,
        CorePlugin.sosCommand,
        CorePlugin.setModRoleCommand,
        CorePlugin.configCommand
    )

    override val settings: Seq[Setting[_]] = Seq(
        new ModRoleSetting
    )
}

object CorePlugin {

    /**
      * An instance of the [[commands.VersionCommand]]
      */
    val versionCommand: VersionCommand = new VersionCommand

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

    /**
      * An instance of the [[commands.ConfigCommand]]
      */
    val configCommand: ConfigCommand = new ConfigCommand
}
