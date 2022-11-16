package strategy

type RouteBuilder = func() string

var BikeStrategy RouteBuilder = func() string {
	return "Bike route"
}
var CarStrategy RouteBuilder = func() string {
	return "Car strategy"
}
var AirplaneStrategy RouteBuilder = func() string {
	return "Airplane route"
}
var WalkerStrategy RouteBuilder = func() string {
	return "Walk route"
}

type Map struct {
	routeStrategy RouteBuilder
}

func NewMap(strategy RouteBuilder) *Map {
	return &Map{routeStrategy: strategy}
}
func (m *Map) CreateRoute() string {
	return m.routeStrategy()
}
func (m *Map) ChangeStrategy(strategy RouteBuilder) *Map {
	m.routeStrategy = strategy
	return m
}
