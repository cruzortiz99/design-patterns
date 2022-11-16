import unittest
from patterns.behavioral.template_method import DataReaderTemplate


class TemplateMethodTest(unittest.TestCase):
    def test_should_allow_to_change_the_inner_value_when_map_is_called(self):
        data = ["test", "test"]
        data_reader = DataReaderTemplate(lambda: data)
        data_reader_mapped = data_reader.map(
            lambda data, key: f"{data} mapped {key}")
        for key, value in enumerate(data):
            self.assertEqual(
                f"{value} mapped {key}",
                data_reader_mapped.get()[key])

    def test_should_allow_to_filter_the_inner_value_when_filter_is_called(
            self):
        data = ["test", "test"]
        data_reader = DataReaderTemplate(lambda: data)
        data_reader_filtered = data_reader.filter(
            lambda _, key: key > 0)
        self.assertEqual(
            len(list(
                filter(lambda keyValue: keyValue[0] > 0, enumerate(data)))),
            len(data_reader_filtered.get()))

    def test_should_allow_to_reduce_the_inner_value_when_reduce_is_called(
            self):
        data = ["test", "test"]
        data_reader = DataReaderTemplate(lambda: data)
        data_reduced = data_reader.reduce(
            lambda acc, current, key: f"{acc} {current} {key} reduced",
            "").get()[0]
        self.assertTrue("reduced" in data_reduced)
