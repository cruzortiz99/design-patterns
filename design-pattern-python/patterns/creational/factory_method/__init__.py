"""
Factory Method Package
"""


class Car:
    pass


class BigCar(Car):
    pass


class SmallCar(Car):
    pass


class CarFactory:
    def __init__(self) -> None:
        pass

    def produce_car(self) -> Car:
        raise Exception("method not implemented")


class SmallCarFactory(CarFactory):
    def __init__(self) -> None:
        super().__init__()

    def produce_car(self) -> Car:
        return SmallCar()


class BigCarFactory(CarFactory):
    def __init__(self) -> None:
        super().__init__()

    def produce_car(self) -> Car:
        return BigCar()
