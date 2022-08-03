import unittest


from patterns.structural.adapter import AdapterIntToStr, ServicePrintString


class AdapterTest(unittest.TestCase):
    def test_should_return_msg_when_service_is_called(self):
        inputTest = "test"
        service = ServicePrintString()
        result = service.apply(inputTest)
        self.assertNotEqual(inputTest, result)
        self.assertTrue(result.endswith(inputTest))

    def test_should_return_msg_when_adapter_is_called(self):
        inputTest = 234
        service = AdapterIntToStr(ServicePrintString())
        result = service.apply(inputTest)
        self.assertNotEqual(f"{inputTest}", result)
        self.assertTrue(result.endswith(f"{inputTest}"))
