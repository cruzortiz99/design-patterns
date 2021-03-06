package flyweightcache

type ColorShape struct {
	color string
	shape string
}

func NewColorShape(color string, shape string) ColorShape {
	return ColorShape{color: color, shape: shape}
}

func (cs *ColorShape) Move(context *Particle, x int, y int) *Particle {
	context.x = x
	context.y = y
	return context
}
func (cs *ColorShape) GetColor() string {
	return cs.color
}
func (cs *ColorShape) GetShape() string {
	return cs.shape
}
