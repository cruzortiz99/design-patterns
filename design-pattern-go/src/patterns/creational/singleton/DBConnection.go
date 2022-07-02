package singleton

type dBConnection struct {
	host     string
	port     int
	username string
	password string
}

var instance *dBConnection

func Create(host string, port int, username string, password string) *dBConnection {
	if instance == nil {
		instance = &dBConnection{
			host: host, port: port, username: username, password: password}
		return instance
	}
	return instance
}

func (d *dBConnection) GetHost() string {
	return d.host
}
func (d *dBConnection) GetPort() int {
	return d.port
}
func (d *dBConnection) GetUsername() string {
	return d.username
}
func (d *dBConnection) GetPassword() string {
	return d.password
}
