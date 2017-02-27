package com.cobble.bot.command

import sx.blah.discord.handle.obj.IMessage

trait Command {

    val helpText: String

    def execute(message: IMessage, args: Array[String]): Unit

}
