package state

import (
	"design_patterns_training/patterns/behavioral/state"
	"testing"
)

func TestShouldChangeToGreenWhenRedChange(t *testing.T) {
	var initialLight = (state.TrafficLightState)(&state.RedLight{})
	var trafficLight = state.NewTrafficLight(&initialLight)
	var lightObtained = *trafficLight.ChangeLight().CurrentLight()
	if typeReceived, ok := lightObtained.(*state.GreenLight); !ok {
		t.Fatalf("[obtained: %T; expected: GreenLight]", typeReceived)
	}
}
func TestShouldChangeToRedWhenYellowChange(t *testing.T) {
	var initialLight = (state.TrafficLightState)(&state.YellowLight{})
	var trafficLight = state.NewTrafficLight(&initialLight)
	var lightObtained = *trafficLight.ChangeLight().CurrentLight()
	if typeReceived, ok := lightObtained.(*state.RedLight); !ok {
		t.Fatalf("[obtained: %T; expected: RedLight]", typeReceived)
	}
}
func TestShouldChangeToYellowWhenGreenChange(t *testing.T) {
	var initialLight = (state.TrafficLightState)(&state.GreenLight{})
	var trafficLight = state.NewTrafficLight(&initialLight)
	var lightObtained = *trafficLight.ChangeLight().CurrentLight()
	if typeReceived, ok := lightObtained.(*state.YellowLight); !ok {
		t.Fatalf("[obtained: %T; expected: Yellow]", typeReceived)
	}
}
