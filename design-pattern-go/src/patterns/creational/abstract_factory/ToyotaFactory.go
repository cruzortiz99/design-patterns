package abstract_factory

type ToyotaFactory struct {
	VehicleFactory
}

func (f *ToyotaFactory) CreateDeportiveCar() DeportiveCar {
	return ToyotaYaris{}
}
func (f *ToyotaFactory) CreateRusticCar() RusticCar {
	return ToyotaForRunner{}
}
