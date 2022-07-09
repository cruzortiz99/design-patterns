import unittest
from patterns.structural.decorator import LoggerDecorator
from patterns.structural.decorator import ServicePrintString
from patterns.structural.decorator import ServiceInterface


class DecoratorMock(LoggerDecorator):
    def __init__(self, service: ServiceInterface) -> None:
        super().__init__(service)
        self._was_called = False

    def log(self, value: str) -> None:
        self._was_called = True
        return super().log(value)

    def has_been_called(self) -> bool:
        return self._was_called


class ServiceMock(ServicePrintString):
    def __init__(self) -> None:
        super().__init__()
        self._was_called = False

    def run(self, value: str) -> str:
        self._was_called = True
        return super().run(value)

    def has_been_called(self) -> bool:
        return self._was_called


class DecoratorTest(unittest.TestCase):
    def test_should_call_the_extra_method(self):
        service = ServicePrintString()
        decorator = DecoratorMock(service)
        decorator.run("test")
        self.assertTrue(decorator.has_been_called())

    def test_should_call_wrapped_method(self):
        service = ServiceMock()
        DecoratorMock(service).run("test")
        self.assertTrue(service.has_been_called())
