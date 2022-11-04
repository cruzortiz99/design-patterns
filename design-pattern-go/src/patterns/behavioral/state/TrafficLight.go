package state

type trafficLight struct {
	state *TrafficLightState
}

func NewTrafficLight(initialState *TrafficLightState) *trafficLight {
	if initialState == nil {
		light := (TrafficLightState)(&RedLight{})
		return &trafficLight{state: &light}
	}
	return &trafficLight{state: initialState}
}

func (tl *trafficLight) ChangeLight() *trafficLight {
	tl.state = (*tl.state).ChangeLight()
	return tl
}
func (tl *trafficLight) CurrentLight() *TrafficLightState {
	return tl.state
}
