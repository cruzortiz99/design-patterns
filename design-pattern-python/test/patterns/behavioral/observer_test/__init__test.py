import unittest
from patterns.behavioral.observer import NewsPaper, Notice


class ObserverTest(unittest.TestCase):
    def test_notify_every_reader_about_when_notify(self):
        was_reader1_called = False
        was_reader2_called = False
        news_paper = NewsPaper()

        def reader1(_: Notice):
            nonlocal was_reader1_called
            was_reader1_called = True

        def reader2(_: Notice):
            nonlocal was_reader2_called
            was_reader2_called = True

        news_paper.subscribe(reader1)
        news_paper.subscribe(reader2)

        news_paper.notify(Notice("test"))

        self.assertTrue(was_reader1_called)
        self.assertTrue(was_reader2_called)

    def test_dont_notify_when_reader_was_unsubscribe(self):
        was_reader1_called = False
        was_reader2_called = False
        news_paper = NewsPaper()

        def reader1(_: Notice):
            nonlocal was_reader1_called
            was_reader1_called = True

        def reader2(_: Notice):
            nonlocal was_reader2_called
            was_reader2_called = True

        news_paper.subscribe(reader1)
        news_paper.subscribe(reader2).unsubscribe()

        news_paper.notify(Notice("test"))

        self.assertTrue(was_reader1_called)
        self.assertFalse(was_reader2_called)
