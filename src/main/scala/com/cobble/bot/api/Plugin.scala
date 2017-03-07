package com.cobble.bot.api

/**
  * A trait that should be implemented by any plugin that is going to be used by the bot.
  *
  * @author Cobbleopolis
  * @version 1.0.0
  * @since 1.0.0
  */
trait Plugin {

    /**
      * The internal name of the plugin.
      */
    val name: String

    /**
      * The name of the plugin that will be displayed to the user.
      */
    val displayName: String

    /**
      * A list of commands that will be registered when the plugin loads.
      */
    val commands: Seq[Command]

}
