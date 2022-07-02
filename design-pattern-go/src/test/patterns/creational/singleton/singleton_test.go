package singleton

import (
	"design_patterns_training/patterns/creational/singleton"
	"strings"
	"testing"
)

func TestShouldCreateADBConnetionWhenCreateIsCalled(t *testing.T) {
	host := "test.com"
	port := 8443
	username := "test"
	password := "*****"
	connection := singleton.Create(host, port, username, password)
	if host != connection.GetHost() || port != connection.GetPort() ||
		username != connection.GetUsername() || password != connection.GetPassword() {
		t.Fatal(strings.Join([]string{
			"Values does not corresponds the expected",
			"Expected: [host: %v, port: %v, username: %v, password: %v]",
			"Obtained: [host: %v, port: %v, username: %v, password: %v]",
		}, ""),
			host, port, username, password,
			connection.GetHost(), connection.GetPort(),
			connection.GetUsername(), connection.GetPassword())

	}
}
func TestShouldCreateOnlyOneInstanceWhenCreateIsCalledMoreThanOnce(t *testing.T) {
	host := "test.com"
	port := 8443
	username := "test"
	password := "*****"
	connection := singleton.Create(host, port, username, password)
	for i := 0; i < 10; i++ {
		dbConnection := singleton.Create(
			host, port+i, username, password)
		if connection != dbConnection {
			t.Fatal("Instance is not the same")
		}
	}
}
