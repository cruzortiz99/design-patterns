from typing import TypeVar, Generic, Callable, List
T = TypeVar('T')
NT = TypeVar('NT')


class DataReaderTemplate(Generic[T]):
    def __init__(self, producer: Callable[[], List[T]]) -> None:
        super().__init__()
        self.data_producer = producer

    def map(self, mapper: Callable[[T, int], NT]) -> 'DataReaderTemplate[NT]':
        return DataReaderTemplate(
            lambda: list(map(
                lambda keyValue: mapper(keyValue[1], keyValue[0]),
                enumerate(self.data_producer())))
        )

    def filter(self,
               predicate: Callable[[T, int], bool]) -> 'DataReaderTemplate[T]':
        return DataReaderTemplate(
            lambda: list(
                map(lambda keyValue: keyValue[1],
                    filter(
                    lambda keyValue: predicate(keyValue[1], keyValue[0]),
                    enumerate(self.data_producer())))
            ))

    def reduce(self,
               accumulator: Callable[[NT, T, int], NT],
               initialValue: NT) -> 'DataReaderTemplate[NT]':
        def _producer() -> List[NT]:
            acc = initialValue
            for key, value in enumerate(self.data_producer()):
                acc = accumulator(acc, value, key)
            return [acc]
        return DataReaderTemplate(_producer)

    def get(self) -> List[T]:
        return self.data_producer()
