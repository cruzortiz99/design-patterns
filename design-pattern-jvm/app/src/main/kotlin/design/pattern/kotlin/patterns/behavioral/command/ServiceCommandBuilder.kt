package design.pattern.kotlin.patterns.behavioral.command

class ServiceCommandBuilder(private val service: Service) {
    inner class ServiceCommand constructor(private val command: ServiceCommandBuilder) {
        fun Run() {
            command.service.apply(command.value)
        }
    }

    private var value: String? = null
    fun setArgs(value: String?): ServiceCommand {
        this.value = value
        return ServiceCommand(this)
    }
}