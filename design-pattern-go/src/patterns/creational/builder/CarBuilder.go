package builder

type CarBuilder struct {
	car car
}

func NewCarBuilder() *CarBuilder {
	return &CarBuilder{car{
		Doors:      2,
		Motor:      "4L",
		Lts:        1.4,
		AC:         false,
		Electronic: false,
	}}
}
func (b *CarBuilder) SetDoors(doors int) *CarBuilder {
	b.car.Doors = doors
	return b
}
func (b *CarBuilder) SetMotors(motor string) *CarBuilder {
	b.car.Motor = motor
	return b
}
func (b *CarBuilder) SetLts(lts float32) *CarBuilder {
	b.car.Lts = lts
	return b
}
func (b *CarBuilder) SetElectronic(electronic bool) *CarBuilder {
	b.car.Electronic = electronic
	return b
}
func (b *CarBuilder) Build() car {
	return b.car
}
