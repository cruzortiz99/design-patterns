class ServicePrintString:
    def __init__(self) -> None:
        pass

    def apply(self, input: str) -> str:
        return f"From Service received: {input}"


class AdapterIntToStr:
    def __init__(self, service: ServicePrintString) -> None:
        self.service = service

    def apply(self, input: int) -> str:
        return self.service.apply(f"{input}")
