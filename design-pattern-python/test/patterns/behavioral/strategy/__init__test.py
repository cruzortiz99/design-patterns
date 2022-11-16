import unittest
from patterns.behavioral.strategy import Map


class StrategyTest(unittest.TestCase):
    def test_should_run_strategy_when_create_route_is_called(self):
        was_called = False

        def route_builder():
            nonlocal was_called
            was_called = True
            return ""
        test_map = Map(route_builder)
        test_map.create_route()
        self.assertTrue(was_called)
