package factory_method

type BigCarFactory struct {
	CarFactory
}

func (f *BigCarFactory) ProduceCar() BigCar {
	return BigCar{Car: Car{}}
}
