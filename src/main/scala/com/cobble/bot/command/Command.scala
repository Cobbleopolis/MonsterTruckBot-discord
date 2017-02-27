package com.cobble.bot.command

import sx.blah.discord.handle.obj.IMessage

trait Command {

    //TODO add ability to set name in command

    val helpText: String

    def execute(message: IMessage, args: Array[String]): Unit

}
