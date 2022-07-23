package design.pattern.java.patterns.structural.proxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProxyTest {
  class ServiceMock implements Service {
    private Service service;
    private Boolean wasCalled;
    private Integer times;

    ServiceMock(Service service) {
      super();
      this.service = service;
      this.wasCalled = false;
      this.times = 0;
    }

    @Override
    public String addPrefix(String word) {
      this.wasCalled = true;
      this.times++;
      return this.service.addPrefix(word);
    }

    public Boolean hasBeenCalled() {
      return this.wasCalled;
    }

    public Boolean hasBeenCalledTimes(Integer num) {
      return this.times == num;
    }
  }

  @Test
  public void testShouldCallServiceWhenSameMethodProxyIsCalled() {
    var mock = new ServiceMock(new AddCustomPrefix(""));
    var proxy = new ServiceProxy(mock);
    proxy.addPrefix("word");
    Assertions.assertTrue(mock.hasBeenCalled());
  }

  @Test
  public void testShouldCallService1WhenMthIsCalledMultTimes() {
    var mock = new ServiceMock(new AddCustomPrefix("-"));
    var proxy = new ServiceProxy(mock);
    proxy.addPrefix("1");
    proxy.addPrefix("1");
    proxy.addPrefix("1");
    Assertions.assertTrue(mock.hasBeenCalledTimes(1));
  }

  @Test
  public void testShouldReturnCachedValueWhenSameParamIsSent() {
    var service = new AddCustomPrefix("");
    var proxy = new ServiceProxy(service);
    var first = proxy.addPrefix("word");
    var second = proxy.addPrefix("word");
    var third = proxy.addPrefix("word");
    Assertions.assertTrue(first == second && second == third);
  }

}
