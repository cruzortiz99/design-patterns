package bridge_test

import (
	"design_patterns_training/patterns/structural/bridge"
	"strconv"
	"strings"
	"testing"
)

type SomeLibraryMock struct {
	bridge.SomeLibraryInterface
}

func (m SomeLibraryMock) WriteString() string {
	return "writeString"
}
func (m SomeLibraryMock) WriteOtherString() string {
	return "writeOtherString"
}
func (m SomeLibraryMock) IntegerGenerator() int {
	return 20
}

func TestShouldCallLibraryMethodsWhenBridgeFeatureIsCalled(t *testing.T) {
	someLibraryMock := SomeLibraryMock{}
	bridge := bridge.New(someLibraryMock)
	result := bridge.ConcreteFeature()
	if !strings.Contains(result, someLibraryMock.WriteString()) {
		t.Fatal("WriteString was not Called")
	} else if !strings.Contains(result, someLibraryMock.WriteOtherString()) {
		t.Fatal("WriteOtherString was not Called")
	} else if !strings.Contains(result, strconv.Itoa(
		someLibraryMock.IntegerGenerator())) {
		t.Fatal("IntegerGenerator was not Called")
	}
}
