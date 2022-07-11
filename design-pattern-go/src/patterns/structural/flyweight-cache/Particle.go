package flyweightcache

type Particle struct {
	x              int
	y              int
	repeatingState *ColorShape
}

func NewParticle(x int, y int, colorShape *ColorShape) Particle {
	return Particle{x: x, y: y, repeatingState: colorShape}
}

func (p *Particle) Move(x int, y int) *Particle {
	p.x = x
	p.y = y
	return p
}

func (p *Particle) getX() int {
	return p.x
}
func (p *Particle) getY() int {
	return p.y
}
