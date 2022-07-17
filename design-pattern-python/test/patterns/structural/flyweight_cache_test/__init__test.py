import unittest
from patterns.structural.flyweight_cache import ColorShape, Particle


class ColorShapeMock(ColorShape):
    def __init__(self, color: str, shape: str) -> None:
        self._was_called = False
        super().__init__(color, shape)

    def move(self, context: "Particle", x: int, y: int) -> "Particle":
        self._was_called = True
        return super().move(context, x, y)

    def has_been_called(self) -> bool:
        return self._was_called


class FlyWeightCacheTest(unittest.TestCase):
    def test_should_return_unique_color_shape_when_is_not_cached(self):
        unique_state = ColorShape("blue", "circle")
        particle = Particle(3, 2, unique_state)
        self.assertTrue(particle.repeating_state is unique_state)

    def test_should_return_cached_color_shape_when_is_cached(self):
        unique_state = ColorShape("blue", "circle")
        cached_state = ColorShape("blue", "circle")
        Particle(2, 1, unique_state)
        particle2 = Particle(3, 2, cached_state)
        self.assertTrue(particle2.repeating_state is not cached_state)

    def test_should_call_cached_meth_when_ctxt_meth_is_call_optional(self):
        unique_state = ColorShapeMock("blue", "circle")
        particle = Particle(1, 2, unique_state)
        particle.move(1, 2)
        self.assertTrue(unique_state.has_been_called())
