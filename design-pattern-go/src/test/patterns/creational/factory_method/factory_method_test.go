package factory_method

import (
	"design_patterns_training/patterns/creational/factory_method"
	"testing"
)

func TestShouldCreateSmallCarWhenSmallCarFactoryProduceCar(t *testing.T) {
	var factory factory_method.CarFactory = &factory_method.SmallCarFactory{}
	car, ok := factory.ProduceCar().(factory_method.SmallCar)
	if !ok {
		t.Fatalf("Car must be Small Car, type received %T\n", car)
	}
}

func TestShouldCreateBigCarWhenBigFactoryProduceCar(t *testing.T) {
	var factory factory_method.CarFactory = &factory_method.BigCarFactory{}
	car, ok := factory.ProduceCar().(factory_method.BigCar)
	if !ok {
		t.Fatalf("Car must be Big Car, type received %T\n", car)
	}
}
