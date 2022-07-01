import unittest
from patterns.creational.factory_method import SmallCarFactory, SmallCar
from patterns.creational.factory_method import BigCarFactory, BigCar


class FactoryMethodTest(unittest.TestCase):
    def test_should_create_small_car_when_small_car_factory_is_used(self):
        factory = SmallCarFactory()
        car = factory.produce_car()
        self.assertIsInstance(car, SmallCar)

    def test_should_create_big_car_when_big_car_factory_is_used(self):
        factory = BigCarFactory()
        car = factory.produce_car()
        self.assertIsInstance(car, BigCar)


if __name__ == "__main__":
    unittest.main()
