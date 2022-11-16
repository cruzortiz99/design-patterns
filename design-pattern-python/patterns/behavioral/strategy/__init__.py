from typing import Callable
RouteBuilder = Callable[[], str]

BikeStrategy: RouteBuilder = lambda: "Bike route"
CarStrategy: RouteBuilder = lambda: "Car route"
AirplaneStrategy: RouteBuilder = lambda: "Airplane route"
WalkerStrategy: RouteBuilder = lambda: "Walk route"


class Map:
    def __init__(self, strategy: RouteBuilder) -> None:
        self.route_builder = strategy

    def create_route(self) -> str:
        return self.route_builder()

    def change_strategy(self, strategy: RouteBuilder) -> 'Map':
        self.route_builder = strategy
        return self
