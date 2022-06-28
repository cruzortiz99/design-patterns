package builder

import (
	"design_patterns_training/patterns/creational/builder"
	"testing"
)

func TestShouldCreateACarWithTheCorrectValuesWhenBuilderBuildIsCalled(t *testing.T) {
	doorsExpected := 2
	motorExpected := "6V"
	var ltsExpected float32 = 1.6
	acExpected := true
	electronicExpected := true
	car := builder.NewCarBuilder().SetDoors(doorsExpected).SetMotors(motorExpected).
		SetLts(float32(ltsExpected)).SetAc(acExpected).
		SetElectronic(electronicExpected).Build()
	if car.Doors != doorsExpected || car.Motor != motorExpected ||
		car.Lts != ltsExpected || car.AC != acExpected ||
		car.Electronic != electronicExpected {
		t.Fatalf("Car values does not match as expected, received %v\n", car)
		t.Fatalf("Expected: doors [%v] motor [%v] lts [%v]  ac [%v] electrinics [%v]\n",
			doorsExpected, motorExpected, ltsExpected, acExpected, electronicExpected)
	}
}
