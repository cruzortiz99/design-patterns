from typing import Callable, List, TypeAlias


class Notice:
    def __init__(self, description: str):
        self.description = description


NewsPaperReader: TypeAlias = Callable[[Notice], None]


class NewsPaper:
    def __init__(self) -> None:
        self.readers: List[NewsPaperReader] = []

    def subscribe(self, reader: NewsPaperReader) -> 'NewsPaperSubscription':
        self.readers.append(reader)
        return NewsPaperSubscription(self, reader)

    def notify(self, news: Notice) -> None:
        for reader in self.readers:
            reader(news)


class NewsPaperSubscription:
    def __init__(self,
                 observable: NewsPaper,
                 observer: NewsPaperReader) -> None:
        self.observable = observable
        self.observer = observer

    def unsubscribe(self) -> None:
        self.observable.readers.remove(self.observer)
