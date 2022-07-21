package proxy

type ServiceCacheFactory struct {
	cache map[string]any
}

var instance *ServiceCacheFactory

func CreateServiceCacheFactory() *ServiceCacheFactory {
	if instance == nil {
		var localInstance = newServiceCacheFactory()
		instance = &localInstance
	}
	return instance
}

func newServiceCacheFactory() ServiceCacheFactory {
	return ServiceCacheFactory{cache: map[string]any{}}
}

func (c *ServiceCacheFactory) IsCached(paramString string) bool {
	return c.cache[paramString] != nil
}

func (c *ServiceCacheFactory) SaveInCache(paramString string, value any) any {
	c.cache[paramString] = value
	return value
}
func (c *ServiceCacheFactory) GetInCache(paramsString string) any {
	return c.cache[paramsString]
}
