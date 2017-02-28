package com.cobble.bot.command

import sx.blah.discord.handle.obj.IMessage

/**
  * A trait that should be implemented by any command that is going to be used by the bot.
  * @author Cobbleopolis
  * @version 1.0.0
  * @since 1.0.0
  */
trait Command {

    /**
      * The name of the command. This is used when registering the command.
      */
    val name: String

    /**
      * The text that defines how the arguments of the command is formatted.
      *
      * This should not include the name of the command.
      */
    val usageText: String

    /**
      * Gives a description of what the command does and how to use it.
      */
    val helpText: String

    /**
      * Gives a brief description of what the command does.
      *
      * This is displayed in the [[HelpCommand]] when it is given no arguments.
      */
    val briefHelpText: String

    /**
      * Called when the command is executed.
      * @param message The message object that called the command.
      * @param args The arguments that are passed to the command. This can be empty.
      */
    def execute(message: IMessage, args: Array[String]): Unit

}
