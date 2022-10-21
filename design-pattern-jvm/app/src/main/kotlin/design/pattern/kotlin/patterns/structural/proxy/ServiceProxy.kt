package design.pattern.kotlin.patterns.structural.proxy

class ServiceProxy(private val service: Service) : Service {
    private val cache: ServiceCacheFactory? = ServiceCacheFactory.create()
    override fun addPrefix(word: String): String {
        return if (cache == null) "" else if (cache.isCached(word)) cache
            .getInCache(word) as String else cache.saveInCache(
            word,
            service.addPrefix(word)
        )
    }

}