package proxy

type ServiceProxy struct {
	service Service
	cache   *ServiceCacheFactory
	Service
}

func NewServiceProxy(service Service) ServiceProxy {
	return ServiceProxy{
		service: service,
		cache:   CreateServiceCacheFactory(),
	}
}
func (p *ServiceProxy) AddPrefix(word string) string {
	if p.cache.IsCached(word) {
		return p.cache.GetInCache(word).(string)
	}
	var service = p.service
	return p.cache.SaveInCache(word, service.AddPrefix(word)).(string)
}
