from typing import Generic, TypeVar
T = TypeVar('T')


class Producer(Generic[T]):
    def has_next(self) -> bool:
        raise Exception("Must implement method")

    def next(self) -> T:
        raise Exception("Must implement method")


class FibonacciProducer(Producer[int]):
    def __init__(self) -> None:
        super().__init__()
        self.index = 0
        self.current = 1
        self.prev = 0

    def has_next(self) -> bool:
        return self.index < 10

    def next(self) -> int:
        if (self.has_next() is not True):
            raise IndexError("Index out of Bound")
        if self.current == 0:
            self.current = 1
            self.prev = 0
        self.current += self.prev
        self.prev = self.current - self.prev
        self.index += 1
        return self.current
