import unittest
from services import greetings

print(greetings())


class TestFirst(unittest.TestCase):
    def test_should_return_str_when_executes(self):
        self.assertIsInstance(greetings(), str)


if __name__ == "__main__":
    unittest.main()
