package command

import sx.blah.discord.handle.impl.events.MessageReceivedEvent

trait Command {

    val usageText: String

    def execute(event: MessageReceivedEvent): Unit

}
