class __Car:
    def __init__(self, doors: int, motor: str,
                 lts: float, ac: bool, electronic: bool) -> None:
        self.doors = doors
        self.motor = motor
        self.lts = lts
        self.ac = ac
        self.electronic = electronic


class CarBuilder:
    def __init__(self):
        self.__car = __Car(2, "4L", 1.4, False, False)

    def set_doors(self, doors: int) -> "CarBuilder":
        self.__car.doors = doors
        return self

    def set_motor(self, motor: str) -> "CarBuilder":
        self.__car.motor = motor
        return self

    def set_lts(self, lts: float) -> "CarBuilder":
        self.__car.lts = lts
        return self

    def set_ac(self, ac: bool) -> "CarBuilder":
        self.__car.ac = ac
        return self

    def set_electronics(self, electronics: bool) -> "CarBuilder":
        self.__car.electronic = electronics
        return self

    def build(self) -> __Car:
        return self.__car
