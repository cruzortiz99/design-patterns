package mediator

type ControlTower struct {
}

func NewControlTower() *ControlTower {
	return &ControlTower{}
}

func (ct *ControlTower) Notify(_ Airship, event string) string {
	switch event {
	case "beforeLand":
		return "preparing route to land"
	case "afterLand":
		return "preparing for passengers unboarding"
	case "afterLiftOff":
		return "cleaning up route to other airship"
	default:
		return "preparing route to lift off"
	}
}
