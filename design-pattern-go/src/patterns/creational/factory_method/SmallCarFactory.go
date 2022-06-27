package factory_method

type SmallCarFactory struct {
	CarFactory
}

func (f *SmallCarFactory) ProduceCar() SmallCar {
	return SmallCar{Car: Car{}}
}
