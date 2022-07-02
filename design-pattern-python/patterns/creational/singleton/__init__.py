_instance = None


class _DBConnection:
    def __init__(self,
                 host: str,
                 port: int,
                 username: str,
                 password: str) -> None:
        self._host = host
        self._port = port
        self._username = username
        self._password = password

    def get_host(self) -> str:
        return self._host

    def get_port(self) -> int:
        return self._port

    def get_username(self) -> str:
        return self._username

    def get_password(self) -> str:
        return self._password


def DBConnection_create(host: str, port: int,
                        username: str, password: str) -> _DBConnection:
    global _instance
    if _instance is None:
        _instance = _DBConnection(host, port, username, password)
        return _instance
    return _instance
