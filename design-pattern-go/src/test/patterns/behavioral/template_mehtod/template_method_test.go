package templatemehtod

import (
	templatemehtod "design_patterns_training/patterns/behavioral/template_mehtod"
	"strings"
	"testing"
)

func TestShouldAllowToChangeTheInnerValueWhenMapIsCalled(t *testing.T) {
	var data = []string{"test", "test"}
	var dataReader = templatemehtod.NewDataReaderTemplate(func() []string {
		return data
	})
	var dataReaderMapped = templatemehtod.Map(dataReader, func(s string) string {
		return strings.Join([]string{s, "mapped"}, " ")
	})
	for key, value := range data {
		if dataReaderMapped.Get()[key] !=
			strings.Join([]string{value, "mapped"}, " ") {
			t.Fatalf("\nValues must be equal, differ on key %v", key)
		}
	}
}
func TestShouldAllowToFilterTheInnerValueWhenFilterIsCalled(t *testing.T) {
	var data = []string{"test", "test longer"}
	var dataReader = templatemehtod.NewDataReaderTemplate(func() []string {
		return data
	})
	var dataReaderFiltered = templatemehtod.Filter(dataReader,
		func(s string) bool {
			return len(s) > 4
		})
	if len(dataReaderFiltered.Get()) == len(data) {
		t.Fatalf("\nData obtained should be less, obtained %v", len(data))
	}
}
func TestShouldAllowToReduceTheInnerValueWhenReduceIsCalled(t *testing.T) {
	var data = []string{"test", "test longer"}
	var dataReader = templatemehtod.NewDataReaderTemplate(func() []string {
		return data
	})
	var dataReaderReduced = templatemehtod.Reduce(dataReader, func(acc string, current string) string {
		return strings.Join([]string{current, "reduced", acc}, " ")
	}, "")
	var dataReduced = dataReaderReduced.Get()[0]
	if !strings.Contains(dataReduced, "reduced") {
		t.Fatalf("Should be reduce, obtained %v", dataReduced)
	}
}
