import unittest
from patterns.structural.proxy import AddCustomPrefixService
from patterns.structural.proxy import Service
from patterns.structural.proxy import ServiceProxy


class ServiceMock(Service):
    def __init__(self, service: Service) -> None:
        super().__init__()
        self.was_called = False
        self.times = 0
        self.service = service

    def add_prefix(self, word: str) -> str:
        self.was_called = True
        self.times += 1
        return self.service.add_prefix(word)

    def has_been_called(self) -> bool:
        return self.was_called

    def has_been_called_times(self, num: int) -> bool:
        return self.times == num


class ProxyTest(unittest.TestCase):

    def test_should_call_service_when_same_method_proxy_is_called(self):
        mock = ServiceMock(AddCustomPrefixService(""))
        proxy = ServiceProxy(mock)
        proxy.add_prefix("test")
        self.assertTrue(mock.has_been_called())

    def test_should_call_service_1_when_mth_is_called_mult_times(self):
        mock = ServiceMock(AddCustomPrefixService(""))
        proxy = ServiceProxy(mock)
        proxy.add_prefix("1")
        proxy.add_prefix("1")
        proxy.add_prefix("1")
        self.assertTrue(mock.has_been_called_times(1))

    def test_should_return_cached_value_when_same_param_is_sent(self):
        service = AddCustomPrefixService("1")
        proxy = ServiceProxy(service)
        first = proxy.add_prefix("13")
        second = proxy.add_prefix("13")
        third = proxy.add_prefix("13")
        self.assertTrue(first is second and second is third)
