package design.pattern.java.patterns.structural.proxy;

import java.util.HashMap;
import java.util.Map;

public class ServiceCacheFactory {
  private static ServiceCacheFactory instance;

  public static ServiceCacheFactory create() {
    if (instance == null) {
      ServiceCacheFactory.instance = new ServiceCacheFactory();
    }
    return ServiceCacheFactory.instance;
  }

  private final Map<String, Object> cache;

  private ServiceCacheFactory() {
    this.cache = new HashMap<>();
  }

  public Boolean isCached(final String paramsString) {
    return this.cache.containsKey(paramsString);
  }

  public <T> T saveInCache(String paramString, T value) {
    this.cache.put(paramString, value);
    return value;
  }

  public Object getInCache(String paramString) {
    return this.cache.get(paramString);
  }
}
