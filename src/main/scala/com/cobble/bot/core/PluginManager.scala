package com.cobble.bot.core

import com.cobble.bot.api.Plugin
import com.cobble.bot.plugins.core.CorePlugin

object PluginManager {

    var registry: Map[String, Plugin] = Map[String, Plugin]()

    /**
      * Registers all of the [[com.cobble.bot.api.Plugin]]s for the bot.
      */
    def registerPlugins(): Unit = {
        registerPlugin(new CorePlugin)
    }

    /**
      * Registers a plugin with the bot.
      *
      * @param plugin The [[com.cobble.bot.api.Plugin]] instance to Register.
      */
    def registerPlugin(plugin: Plugin): Unit = {
        registry += plugin.name -> plugin
        plugin.commands.foreach(command => CommandRegistry.registerCommand(command))
    }

    /**
      * Optionally gets a plugin by name.
      *
      * @param name The name of the plugin to attempt to get.
      * @return
      */
    def getPlugin(name: String): Option[Plugin] = registry.get(name)

}
