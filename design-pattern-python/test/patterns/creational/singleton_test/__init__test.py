import unittest
from patterns.creational.singleton import DBConnection_create


class SingletonTest(unittest.TestCase):
    def test_should_create_one_instance_when_create_is_called(self):
        host = "test.com"
        port = 8443
        username = "test"
        password = "****"
        connection = DBConnection_create(host, port, username, password)
        self.assertEqual(host, connection.get_host())
        self.assertEqual(port, connection.get_port())
        self.assertEqual(username, connection.get_username())
        self.assertEqual(password, connection.get_password())

    def test_should_create_only_1_instance_when_create_is_called_many_times(
            self):
        host = "test.com"
        port = 8443
        username = "test"
        password = "****"
        connection = DBConnection_create(host, port, username, password)
        for index in range(11):
            dbConnection = DBConnection_create(
                host, port + index, username, password)
            self.assertIs(connection, dbConnection)
