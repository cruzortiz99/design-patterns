package strategy

import (
	"design_patterns_training/patterns/behavioral/strategy"
	"testing"
)

func TestShouldRunTheStrategyWhenCreateRouteIsCalled(t *testing.T) {
	var wasCalled = false
	var testMap = strategy.NewMap(func() string {
		wasCalled = true
		return ""
	})
	testMap.CreateRoute()
	if !wasCalled {
		t.Fatal("Strategy should've been called")
	}
}
