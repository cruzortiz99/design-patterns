package prototype

import (
	"design_patterns_training/patterns/creational/prototype"
	"testing"
)

func TestShouldCopyTheValuesWheCopyIsCalled(t *testing.T) {
	car := prototype.CarNew("test")
	carCopy := car.Copy().(prototype.Car)
	if car.Name != carCopy.Name {
		t.Fatalf("car value are not the same")
	}
}

func TestShouldhaveDifferentReferenceWhenCopy(t *testing.T) {
	car := prototype.CarNew("test")
	carCopy := car.Copy().(prototype.Car)
	if car == &carCopy {
		t.Fatalf("car references should no be the same")
	}
}
