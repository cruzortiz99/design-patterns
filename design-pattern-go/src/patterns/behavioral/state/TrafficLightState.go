package state

type TrafficLightState interface {
	ChangeLight() *TrafficLightState
	TrafficAction() string
}

type RedLight struct{}

func (rl *RedLight) ChangeLight() *TrafficLightState {
	light := (TrafficLightState)(&GreenLight{})
	return &light
}
func (rl *RedLight) TrafficAction() string {
	return "Can't pass"
}

type YellowLight struct{}

func (yl *YellowLight) ChangeLight() *TrafficLightState {
	light := (TrafficLightState)(&RedLight{})
	return &light
}
func (yl *YellowLight) TrafficAction() string {
	return "Warning reduce speed"
}

type GreenLight struct{}

func (gl *GreenLight) ChangeLight() *TrafficLightState {
	light := (TrafficLightState)(&YellowLight{})
	return &light
}

func (gl *GreenLight) TrafficAction() string {
	return "You can pass now"
}
