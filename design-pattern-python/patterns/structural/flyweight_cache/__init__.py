from functools import reduce
from typing import List, Union


class ColorShape:
    def __init__(self, color: str, shape: str) -> None:
        self.color = color
        self.shape = shape

    def move(self, context: "Particle", x: int, y: int) -> "Particle":
        return context.setX(x).setY(y)


class Particle:
    def __init__(self, x: int, y: int, color_shape: ColorShape) -> None:
        self._x = x
        self._y = y
        self.repeating_state = color_shape

    def move(self, x: int, y: int) -> "Particle":
        return self.repeating_state.move(self, x, y)

    def setX(self, x: int) -> "Particle":
        self._x = x
        return self

    def setY(self, y: int) -> "Particle":
        self._y = y
        return self

    def getX(self) -> int:
        return self._x

    def getY(self) -> int:
        return self._y


class ParticleFactory:
    def __init__(self, initialSate: Union[ColorShape, None]) -> None:
        self.cache: List[ColorShape] = []
        if initialSate is not None:
            self.cache.append(initialSate)

    def get_cache(self, colorShape: ColorShape) -> ColorShape:
        cachedState: Union[ColorShape, None] = reduce(
            lambda acc, current: current if acc is None else acc,
            list(filter(lambda savedState: savedState.color ==
                        colorShape.color and savedState.shape ==
                        colorShape.shape, self.cache)),
            None)
        if cachedState is None:
            self.cache.append(colorShape)
            return colorShape
        return cachedState
