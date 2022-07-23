from typing import Any, Dict, Optional


class Service:
    def add_prefix(self, word: str) -> str:
        raise Exception("method must be implemented")


class AddCustomPrefixService(Service):
    def __init__(self, prefix: str) -> None:
        super().__init__()
        self.prefix = prefix

    def add_prefix(self, word: str) -> str:
        return f"{self.prefix}{word}"


class ServiceCacheFactory:
    def __init__(self) -> None:
        self.cache: Dict[str, Any] = {}

    def is_cached(self, paramString: str) -> bool:
        return paramString in self.cache and self.cache[
            paramString] is not None

    def save_in_cache(self, paramString: str, value: Any) -> Any:
        self.cache[paramString] = value
        return value

    def get_in_cache(self, paramString: str) -> Any:
        return self.cache[paramString]


__INSTANCE: Optional[ServiceCacheFactory] = None


def create_service_cache_factory() -> ServiceCacheFactory:
    global __INSTANCE
    if __INSTANCE is None:
        __INSTANCE = ServiceCacheFactory()
        return __INSTANCE
    return __INSTANCE


class ServiceProxy(Service):
    def __init__(self, service: Service) -> None:
        super().__init__()
        self.service = service
        self.cache = create_service_cache_factory()

    def add_prefix(self, word: str) -> str:
        if self.cache.is_cached(word):
            return self.cache.get_in_cache(word)
        return self.cache.save_in_cache(word, self.service.add_prefix(word))
