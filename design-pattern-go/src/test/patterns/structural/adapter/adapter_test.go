package adapter

import (
	"design_patterns_training/patterns/structural/adapter"
	"strconv"
	"strings"
	"testing"
)

func TestShouldReturnStringWithMsgWhenServiceIsCalled(t *testing.T) {
	input := "some test"
	service := adapter.ServicePrintString{}
	result := service.Apply(input)
	if input == result || !strings.HasSuffix(result, input) {
		t.Fatalf("input must be different and end with %v", input)
	}
}
func TestShouldReturnStringWithMsgWhenAdapterIsCalled(t *testing.T) {
	input := 20
	service := adapter.AdapterIntToString{}
	service.AddService(adapter.ServicePrintString{})
	result := service.Apply(input)
	if strconv.Itoa(input) == result ||
		!strings.HasSuffix(result, strconv.Itoa(input)) {
		t.Fatalf("input must be different and end with %v", input)
	}
}
