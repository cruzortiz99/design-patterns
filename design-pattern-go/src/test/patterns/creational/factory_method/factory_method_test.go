package factory_method

import (
	"design_patterns_training/patterns/creational/factory_method"
	"reflect"
	"testing"
)

func TestShouldCreateSmallCarWhenSmallCarFactoryProduceCar(t *testing.T) {
	factory := factory_method.SmallCarFactory{}
	car := factory.ProduceCar()
	if reflect.TypeOf(car) != reflect.TypeOf(factory_method.SmallCar{}) {
		t.Fatalf("car type is Not SmallCar")
	}
}

func TestShouldCreateBigCarWhenBigFactoryProduceCar(t *testing.T) {
	factory := factory_method.BigCarFactory{}
	car := factory.ProduceCar()
	if reflect.TypeOf(car) != reflect.TypeOf(factory_method.BigCar{}) {
		t.Fatalf("car type is Not BigCar")
	}
}
