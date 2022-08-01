from typing import Callable, Optional


class ComponentWithHandler:
    def handle(self):
        raise Exception("method must be implemented")


class Leaf(ComponentWithHandler):
    def __init__(self, handler: Optional[Callable[[], None]]) -> None:
        super().__init__()
        self.handler = handler
        self.container: Optional['Container'] = None

    def set_container(self, container: 'Container'):
        self.container = container

    def handle(self):
        if self.handler is not None:
            self.handler()
        elif self.container is not None:
            self.container.handle()


class Container(Leaf):
    def __init__(self, handler: Optional[Callable[[], None]]) -> None:
        super().__init__(handler)

    def add(self, leaf: Leaf) -> 'Container':
        leaf.set_container(self)
        return self
