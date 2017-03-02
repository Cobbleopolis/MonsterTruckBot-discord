package com.cobble.bot.util

import com.cobble.bot.CommandRegistry

object MessageUtil {

    val arrowChar: Char = '\u21D2'

    def formatMessage(userMention: String, message: String): String = s"$userMention $arrowChar $message"

    def getErrorMessage(userMention: String, message: String, throwable: Throwable): String =
        formatMessage(userMention, s"$message \n\nPlease report this message to the bot developer as well as the command you used that returned this error.\n```${throwable.getMessage}```")

    def commandUsageError(userMention: String, message: String, name: String): String = formatMessage(userMention, s"$message Please use `!${CommandRegistry.helpCommand.name} $name` to see how to use this command.")

}
