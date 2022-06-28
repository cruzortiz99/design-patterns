package factory_method

type BigCarFactory struct {
	CarFactory
}

func (f *BigCarFactory) ProduceCar() Car {
	return BigCar{}
}
