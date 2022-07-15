package flyweightcache

type Particle struct {
	x              int
	y              int
	repeatingState *ColorShape
}

func NewParticle(x int, y int, colorShape *ColorShape) Particle {
	var cachedColorShape = CreateParticleCacheFactory(colorShape).GetCache(colorShape)
	return Particle{x: x, y: y, repeatingState: cachedColorShape}
}

func (p *Particle) Move(x int, y int) *Particle {
	p.x = x
	p.y = y
	return p
}

func (p *Particle) GetX() int {
	return p.x
}
func (p *Particle) GetY() int {
	return p.y
}
func (p *Particle) GetColorShape() *ColorShape {
	return p.repeatingState
}
