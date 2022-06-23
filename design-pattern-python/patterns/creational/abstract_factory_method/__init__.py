class DeportCar:
    pass


class FordMustang(DeportCar):
    def __init__(self) -> None:
        super().__init__()


class ToyotaYaris(DeportCar):
    def __init__(self) -> None:
        super().__init__()


class RusticCar:
    pass


class FordPickUp(RusticCar):
    def __init__(self) -> None:
        super().__init__()


class ToyotaForRunner(RusticCar):
    def __init__(self) -> None:
        super().__init__()


class VehicleFactory:
    def create_deport_car(self) -> DeportCar:
        raise Exception("method not implemented")

    def create_rustic_car(self) -> RusticCar:
        raise Exception("method not implemented")


class FordFactory(VehicleFactory):
    def __init__(self) -> None:
        super().__init__()

    def create_deport_car(self) -> DeportCar:
        return FordMustang()

    def create_rustic_car(self) -> RusticCar:
        return FordPickUp()


class ToyotaFactory(VehicleFactory):
    def __init__(self) -> None:
        super().__init__()

    def create_deport_car(self) -> DeportCar:
        return ToyotaYaris()

    def create_rustic_car(self) -> RusticCar:
        return ToyotaForRunner()
