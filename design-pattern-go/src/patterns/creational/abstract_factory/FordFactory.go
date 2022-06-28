package abstract_factory

type FordFactory struct {
	VehicleFactory
}

func (f *FordFactory) CreateDeportiveCar() DeportiveCar {
	return FordMustang{}
}
func (f *FordFactory) CreateRusticCar() RusticCar {
	return FordPickUp{}
}
