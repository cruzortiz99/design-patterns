package design.pattern.kotlin.patterns.structural.proxy

import java.util.HashMap

class ServiceCacheFactory private constructor() {
    private val cache: MutableMap<String, Any>
    fun isCached(paramsString: String): Boolean {
        return cache.containsKey(paramsString)
    }

    fun <T : Any> saveInCache(paramString: String, value: T): T {
        cache[paramString] = value
        return value
    }

    fun getInCache(paramString: String): Any? {
        return cache[paramString]
    }

    companion object {
        private var instance: ServiceCacheFactory? = null
        fun create(): ServiceCacheFactory? {
            if (instance == null) {
                instance = ServiceCacheFactory()
            }
            return instance
        }
    }

    init {
        cache = HashMap()
    }
}