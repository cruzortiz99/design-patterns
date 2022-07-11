package flyweightcache

type ParticleFactory struct {
	cache []*ColorShape
}

var instance *ParticleFactory

func CreateParticleFactory(initialState *ColorShape) *ParticleFactory {
	if instance == nil {
		localInstance := newParticleFactory(initialState)
		instance = &localInstance
	}
	return instance
}

func newParticleFactory(initialState *ColorShape) ParticleFactory {
	cache := []*ColorShape{}
	if initialState != nil {
		cache = append(cache, initialState)
	}
	return ParticleFactory{cache: cache}
}

func (f *ParticleFactory) GetCache(colorShape *ColorShape) *ColorShape {
	var cachedState *ColorShape
	for _, savedState := range f.cache {
		if savedState.color == colorShape.color &&
			savedState.shape == colorShape.shape {
			cachedState = savedState
		}
	}
	if cachedState == nil {
		f.cache = append(f.cache, colorShape)
		return colorShape
	}
	return cachedState
}
