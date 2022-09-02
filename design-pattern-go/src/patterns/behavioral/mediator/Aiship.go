package mediator

type Airship struct {
	controlTower Mediator
}

func NewAirship(controlTower Mediator) *Airship {
	return &Airship{controlTower: controlTower}
}

func (ship *Airship) NotifyBeforeLand() {
	ship.controlTower.Notify(*ship, "beforeLand")
}
func (ship *Airship) NotifyAfterLand() {
	ship.controlTower.Notify(*ship, "afterLand")
}
func (ship *Airship) NotifyBeforeLiftOff() {
	ship.controlTower.Notify(*ship, "beforeLiftOff")
}
func (ship *Airship) NotifyAfterLiftOff() {
	ship.controlTower.Notify(*ship, "afterLiftOff")
}
