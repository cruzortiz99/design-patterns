package abstract_factory

import (
	"design_patterns_training/patterns/creational/abstract_factory"
	"testing"
)

func TestShouldCreateMustangWhenFordFactoryProduceDeportiveCar(t *testing.T) {
	var factory abstract_factory.VehicleFactory = &abstract_factory.FordFactory{}
	car, ok := factory.CreateDeportiveCar().(abstract_factory.FordMustang)
	if !ok {
		t.Fatalf("Type of car must be Ford Mustang, type received %T\n", car)
	}
}
func TestShouldCreatePickUpWhenFordFactoryProduceRusticCar(t *testing.T) {
	var factory abstract_factory.VehicleFactory = &abstract_factory.FordFactory{}
	car, ok := factory.CreateRusticCar().(abstract_factory.FordPickUp)
	if !ok {
		t.Fatalf("Type of car must be Ford PickUp, type received %T\n", car)
	}
}
func TestShouldCreateYarisWhenToyotaFactoryProduceDeportiveCar(t *testing.T) {
	var factory abstract_factory.VehicleFactory = &abstract_factory.ToyotaFactory{}
	car, ok := factory.CreateDeportiveCar().(abstract_factory.ToyotaYaris)
	if !ok {
		t.Fatalf("Type of car must be Ford Mustang, type received %T\n", car)
	}
}
func TestShouldCreateForRunnerWhenToyotaFactoryProduceRusticCar(t *testing.T) {
	var factory abstract_factory.VehicleFactory = &abstract_factory.ToyotaFactory{}
	car, ok := factory.CreateRusticCar().(abstract_factory.ToyotaForRunner)
	if !ok {
		t.Fatalf("Type of car must be Ford PickUp, type received %T\n", car)
	}
}
