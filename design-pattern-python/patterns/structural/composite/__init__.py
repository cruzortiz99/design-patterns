from functools import reduce


class UIComponent:
    def render(self) -> str:
        raise Exception("method not implemented")


class TextComponent(UIComponent):
    def __init__(self, message: str) -> None:
        super().__init__()
        self._message = message

    def render(self) -> str:
        return self._message

    def get_message(self) -> str:
        return self._message


class ContainerComposite(UIComponent):
    def __init__(self, component: UIComponent) -> None:
        super().__init__()
        self.children = [component]

    def render(self) -> str:
        return reduce(
            lambda acc, current: f"{acc}{current}",
            list(map(lambda comp: comp.render(), self.children)),
            ""
        )

    def add(self, component: UIComponent) -> 'ContainerComposite':
        self.children.append(component)
        return self

    def remove(self, component: UIComponent):
        self.children = list(
            filter(
                lambda child: component is not child,
                self.children
            )
        )
