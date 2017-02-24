import command.Command
import sx.blah.discord.api.events.EventSubscriber
import sx.blah.discord.handle.impl.events.{MessageReceivedEvent, ReadyEvent}

class BotEventListener {

    @EventSubscriber
    def onReadyEvent(event: ReadyEvent): Unit = {
        println("Monster Truck Bot ready")
        MonsterTruckBot.client.changeUsername("Monster Truck Bot")
    }

    @EventSubscriber
    def onMessageReceivedEvent(event: MessageReceivedEvent): Unit = {
        if (event.getMessage.getContent.startsWith("!")) {
            val commandOpt: Option[Command] = CommandRegistry.registry.get(event.getMessage.getContent.split(" ").head.substring(1))
            if (commandOpt.isDefined)
                commandOpt.get.execute(event)
        }
        println("Got message: " + event.getMessage.getContent)
    }

}
