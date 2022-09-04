class Mediator:
    def notify(self, airship: 'Airship', event: str) -> str:
        raise Exception("method not implemented")


class Airship:
    def __init__(self, control_tower: Mediator) -> None:
        self.control_tower = control_tower

    def notify_before_land(self):
        self.control_tower.notify(self, 'beforeLand')

    def notify_after_land(self):
        self.control_tower.notify(self, 'afterLand')

    def notify_before_lift_off(self):
        self.control_tower.notify(self, 'beforeLiftOff')

    def notify_after_lift_off(self):
        self.control_tower.notify(self, 'afterLiftOff')


class ControlTower(Mediator):
    def notify(self, airship: 'Airship', event: str) -> str:
        match event:
            case "beforeLand":
                return "preparing for land"
            case "afterLand":
                return "preparing for passengers unboarding"
            case "afterLiftOff":
                return "cleaning up route to other airship"
            case _:
                return "preparing route to lift off"
