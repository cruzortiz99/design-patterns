package abstract_factory

type VehicleFactory interface {
	CreateDeportiveCar() DeportiveCar
	CreateRusticCar() RusticCar
}
