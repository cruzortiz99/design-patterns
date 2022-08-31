import unittest
from patterns.behavioral.iterator import FibonacciProducer


class IteratorTest(unittest.TestCase):
    def test_should_produce_fibonacci_when_next_is_called(self):
        fb_producer = FibonacciProducer()
        prev = 0
        current = 1
        while fb_producer.has_next():
            obtained = fb_producer.next()
            self.assertEqual(obtained, current + prev)
            current += prev
            prev = current - prev

    def test_shoud_raise_exeption_when_index_out_of_bound(self):
        fb_producer = FibonacciProducer()
        while fb_producer.has_next():
            fb_producer.next()
        try:
            fb_producer.next()
            self.fail("Should raise index out of bound")
        except IndexError:
            self.assertTrue(True)
        except Exception:
            self.fail("Should raise index out of bound")
