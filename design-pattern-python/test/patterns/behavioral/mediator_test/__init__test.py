import unittest
from patterns.behavioral.mediator import ControlTower, Airship


class MockControlTower(ControlTower):
    def __init__(self) -> None:
        super().__init__()
        self.was_called = False
        self.arg = ''

    def notify(self, airship: 'Airship', event: str) -> str:
        self.was_called = True
        self.arg = event
        return super().notify(airship, event)

    def has_been_called_with(self, expected) -> bool:
        return self.was_called and self.arg == expected


class MediatorTest(unittest.TestCase):
    def test_should_call_notify_when_airship_emit_event(self):
        ct = MockControlTower()
        Airship(ct).notify_after_land()
        self.assertTrue(ct.has_been_called_with("afterLand"))
