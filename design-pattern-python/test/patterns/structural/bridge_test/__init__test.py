import unittest
from patterns.structural.bridge import SomeLibrary, ServiceBridge


class SomeLibraryMock(SomeLibrary):
    def write_string(self) -> str:
        return "write_string"

    def write_other_string(self) -> str:
        return "write_other_string"

    def integer_generator(self) -> int:
        return 5


class BridgeTest(unittest.TestCase):
    def test_should_call_lib_meth_when_bridge_feature_is_called(self):
        someLibraryMock = SomeLibraryMock()
        bridge = ServiceBridge(someLibraryMock)
        result = bridge.concrete_feature()
        self.assertTrue(someLibraryMock.write_string() in result)
        self.assertTrue(
            someLibraryMock.write_other_string() in result)
        self.assertTrue(
            f"{someLibraryMock.integer_generator()}" in result)