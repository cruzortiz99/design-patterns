package flyweightcache

import (
	cache "design_patterns_training/patterns/structural/flyweight-cache"
	"testing"
)

type ColorShapeMock struct {
	wasCalled bool
	cache.ColorShape
}

func NewColorShapeMock(colorShape cache.ColorShape) ColorShapeMock {
	return ColorShapeMock{wasCalled: false, ColorShape: colorShape}
}
func (m *ColorShapeMock) Move(context *cache.Particle, x int, y int) {
	m.wasCalled = true
	m.ColorShape.Move(context, x, y)
}

type ParticleMock struct {
	colorShape *ColorShapeMock
	cache.Particle
}

func NewParticleMock(colorShape *ColorShapeMock, particle cache.Particle) ParticleMock {
	return ParticleMock{colorShape: colorShape, Particle: particle}
}
func (pm *ParticleMock) Move(x int, y int) *cache.Particle {
	pm.colorShape.Move(&pm.Particle, x, y)
	return &pm.Particle
}

func TestShouldReturnUniqueColorShapeWhenIsNotCached(t *testing.T) {
	var uniqueState = cache.NewColorShape("blue", "circle")
	var particle = cache.NewParticle(9, 8, &uniqueState)
	if &uniqueState != particle.GetColorShape() {
		t.Fatal("Should return same pointer to ColorShape")
	}
}

func TestShouldReturnACachedColorShapeWhenIsCached(t *testing.T) {
	var uniqueState = cache.NewColorShape("blue", "circle")
	var cachedState = cache.NewColorShape("blue", "circle")
	cache.NewParticle(9, 9, &uniqueState)
	var particle2 = cache.NewParticle(8, 8, &cachedState)
	if &cachedState == particle2.GetColorShape() {
		t.Fatal("Reference should be different")
	}
}
func TestShouldCallCachedMethodWhenContextIsCall(t *testing.T) {
	var uniqueState = NewColorShapeMock(cache.NewColorShape("blue", "square"))
	var particle = NewParticleMock(&uniqueState, cache.NewParticle(1, 1, &uniqueState.ColorShape))
	particle.Move(2, 2)
	if !uniqueState.wasCalled {
		t.Fatal("Move was not called on cached color shape")
	}
}
