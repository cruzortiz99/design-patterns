import unittest
from patterns.creational.builder import CarBuilder


class BuilderTest(unittest.TestCase):
    def test_should_create_car_with_the_values_when_builder_build_is_called(
            self):
        doorsExpected = 2
        motorExpected = "6V"
        ltsExpected = 1.6
        acExpected = True
        electronicExpected = True
        carBuilder = CarBuilder()
        car = carBuilder.set_doors(doorsExpected).set_motor(
            motorExpected).set_lts(ltsExpected).set_ac(
            acExpected).set_electronics(electronicExpected).build()
        self.assertEqual(doorsExpected, car.doors)
        self.assertEqual(motorExpected, car.motor)
        self.assertEqual(ltsExpected, car.lts)
        self.assertEqual(acExpected, car.ac)
        self.assertEqual(electronicExpected, car.electronic)
