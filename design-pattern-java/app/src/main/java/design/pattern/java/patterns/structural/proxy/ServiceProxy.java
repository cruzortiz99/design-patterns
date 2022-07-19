package design.pattern.java.patterns.structural.proxy;

public class ServiceProxy implements Service {
  private final Service service;
  private final ServiceCacheFactory cache;

  public ServiceProxy(Service service) {
    this.service = service;
    this.cache = ServiceCacheFactory.create();
  }

  @Override
  public String addPrefix(String word) {
    if (this.cache.isCached(word)) {
      return (String) this.cache.getInCache(word);
    }
    return this.cache.saveInCache(word, this.service.addPrefix(word));
  }

}
