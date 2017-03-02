package com.cobble.bot.command

import sx.blah.discord.handle.obj.{IMessage, IUser}

import scala.collection.mutable

/**
  * The SetModRoleCommand class, this implements the [[Command]] trait.
  *
  * This will set the mod role for the guild it is called in.
  * @author Cobbleopolis
  * @version 1.0.0
  * @since 1.0.0
  */
class SetModRoleCommand extends Command {

    override val name: String = "setModRole"

    override val usageText: String = "<role_mention>"

    override val helpText: String = "Sets the mod role for the discord server"

    override val briefHelpText: String = helpText

    override def execute(message: IMessage, args: Array[String]): Unit = {
        //TODO implement
    }

}
