class Service:
    def apply(self, text: str):
        print(text)


class ServiceCommand:
    def __init__(self, service: Service, value='') -> None:
        self.value = value
        self.service = service

    def set_args(self, value: str) -> 'ServiceCommand':
        self.value = value
        return self

    def run(self):
        if self.value is None or len(self.value) == 0:
            raise Exception('args must have some value')
        return self.service.apply(self.value)
