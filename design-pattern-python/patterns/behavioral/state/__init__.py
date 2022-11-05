class TrafficLightState:
    def change_light(self) -> "TrafficLightState":
        raise Exception("method not implemented")

    def traffic_action(self) -> str:
        raise Exception("Method no implemented")


class RedLight(TrafficLightState):
    def change_light(self) -> "TrafficLightState":
        return GreenLight()


class YellowLight(TrafficLightState):
    def change_light(self) -> "TrafficLightState":
        return RedLight()


class GreenLight(TrafficLightState):
    def change_light(self) -> "TrafficLightState":
        return YellowLight()


class TrafficLight:
    def __init__(self, initial_state: TrafficLightState = RedLight()) -> None:
        self.__state = initial_state

    def change_light(self) -> "TrafficLight":
        self.__state = self.__state.change_light()
        return self

    def traffic_action(self) -> str:
        return self.__state.traffic_action()

    def get_current_state(self) -> TrafficLightState:
        return self.__state
