import unittest
from patterns.creational.abstract_factory_method import FordFactory
from patterns.creational.abstract_factory_method import ToyotaFactory
from patterns.creational.abstract_factory_method import FordMustang, FordPickUp
from patterns.creational.abstract_factory_method import ToyotaYaris
from patterns.creational.abstract_factory_method import ToyotaForRunner


class AbstractFactoryMethodTest(unittest.TestCase):
    def test_should_create_FordMustang_when_is_requested_from_FordFactory(
            self):
        factory = FordFactory()
        car = factory.create_deport_car()
        self.assertIsInstance(car, FordMustang)

    def test_should_create_FordPickUp_when_is_requested_from_FordFactory(self):
        factory = FordFactory()
        car = factory.create_rustic_car()
        self.assertIsInstance(car, FordPickUp)

    def test_should_create_ToyotaYaris_when_is_requested_from_ToyotaFactory(
            self):
        factory = ToyotaFactory()
        car = factory.create_deport_car()
        self.assertIsInstance(car, ToyotaYaris)

    def test_should_create_ForRunner_when_is_requested_from_ToyotaFactory(
            self):
        factory = ToyotaFactory()
        car = factory.create_rustic_car()
        self.assertIsInstance(car, ToyotaForRunner)


if __name__ == "__main__":
    unittest.main()
