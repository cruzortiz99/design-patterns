import math
import random


class SomeLibrary:
    def __init__(self) -> None:
        pass

    def write_string(self) -> str:
        return "String wrote"

    def integer_generator(self) -> int:
        return random.randint(0, 100)

    def write_other_string(self) -> str:
        return "Other string wrote"


class ServiceBridge:
    def __init__(self, someLibrary: SomeLibrary) -> None:
        self.someLibrary = someLibrary

    def concrete_feature(self) -> str:
        return f"""{self.someLibrary.write_string()}
        {self.someLibrary.write_other_string()}
        {self.someLibrary.integer_generator()}
        """
