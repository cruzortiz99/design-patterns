package factory_method

type SmallCarFactory struct {
	CarFactory
}

func (f *SmallCarFactory) ProduceCar() Car {
	return SmallCar{}
}
