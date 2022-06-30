import unittest
from patterns.creational.prototype import Car


class PrototypeTest(unittest.TestCase):
    def test_should_copy_the_values_when_copy_is_called(
            self):
        car = Car("test")
        carCopy = car.copy()
        self.assertEquals(car.name, carCopy.name)

    def test_should_have_different_reference_when_copy(self):
        car = Car("test")
        carCopy = car.copy()
        self.assertNotEqual(car, carCopy)
