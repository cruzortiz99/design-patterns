class ServiceInterface:
    def run(self, value: str) -> str:
        raise Exception("method not implemented")


class ServicePrintString(ServiceInterface):
    def run(self, value: str) -> str:
        return "Print: ".join(value)


class LoggerDecorator(ServiceInterface):
    def __init__(self, service: ServiceInterface) -> None:
        super().__init__()
        self.service = service

    def run(self, value: str) -> str:
        self.log(value)
        return self.service.run(value)

    def log(self, value: str) -> None:
        print("Logging: ".join(value))
