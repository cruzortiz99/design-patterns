class CarPrototype:
    def copy(self) -> 'CarPrototype':
        raise Exception("method not implemented")


class Car(CarPrototype):
    def __init__(self, name: str) -> None:
        super().__init__()
        self.name = name

    def copy(self) -> 'CarPrototype':
        return Car(self.name)
