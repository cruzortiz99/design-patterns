package flyweightcache

type ParticleCacheFactory struct {
	cache []*ColorShape
}

var instance *ParticleCacheFactory

func CreateParticleCacheFactory(initialState *ColorShape) *ParticleCacheFactory {
	if instance == nil {
		localInstance := newParticleCacheFactory(initialState)
		instance = &localInstance
	}
	return instance
}

func newParticleCacheFactory(initialState *ColorShape) ParticleCacheFactory {
	cache := []*ColorShape{}
	if initialState != nil {
		cache = append(cache, initialState)
	}
	return ParticleCacheFactory{cache: cache}
}

func (f *ParticleCacheFactory) GetCache(colorShape *ColorShape) *ColorShape {
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
