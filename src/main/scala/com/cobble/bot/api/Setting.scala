package com.cobble.bot.api

import sx.blah.discord.handle.obj.IMessage

import scala.concurrent.Future

trait Setting[T] {

    val key: String

    def extractValue(message: IMessage, args: Array[String]): Option[T]

    def setValue(guildId: String, value: T): Future[Int]

}
