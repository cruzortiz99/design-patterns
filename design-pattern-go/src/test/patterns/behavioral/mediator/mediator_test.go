package mediator

import (
	"design_patterns_training/patterns/behavioral/mediator"
	"testing"
)

type MockControlTower struct {
	wasCalled bool
	args      string
}

func NewMockControlTower() *MockControlTower {
	return &MockControlTower{}
}

func (mct *MockControlTower) Notify(_ mediator.Airship, event string) string {
	mct.wasCalled = true
	mct.args = event
	return event
}

func (mct *MockControlTower) HasBeenCalledWith(arg string) bool {
	return mct.wasCalled && mct.args == arg
}

func TestShouldCallTheNotifyWhenAirshipEmitEvent(t *testing.T) {
	var ct = NewMockControlTower()
	mediator.NewAirship(ct).NotifyAfterLand()
	if !ct.HasBeenCalledWith("afterLand") {
		t.Fatal("Was not called with the right event")
	}
}
