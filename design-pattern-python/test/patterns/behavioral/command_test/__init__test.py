import unittest
from patterns.behavioral.command import Service,  ServiceCommand


class ServiceMock(Service):
    def __init__(self) -> None:
        super().__init__()
        self.was_called = False

    def apply(self, text: str):
        self.was_called = True
        return super().apply(text)

    def has_been_called(self) -> bool:
        return self.was_called


class CommandTest(unittest.TestCase):
    def test_should_call_method_when_command_executes(self):
        service = ServiceMock()
        command = ServiceCommand(service)
        command.set_args("test").run()
        self.assertTrue(service.has_been_called())
