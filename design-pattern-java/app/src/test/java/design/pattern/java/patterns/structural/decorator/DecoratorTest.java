package design.pattern.java.patterns.structural.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecoratorTest {
  class DecoratorMock extends LoggerDecorator {
    private Boolean wasCalled;

    public DecoratorMock(ServiceInterface service) {
      super(service);
      this.wasCalled = false;
    }

    @Override
    protected void log(String value) {
      this.wasCalled = true;
      super.log(value);
    }

    public Boolean hasBeenCalled() {
      return this.wasCalled;
    }

  }

  class ServiceMock extends ServicePrintString {
    private Boolean wasCalled;

    public ServiceMock() {
      super();
      this.wasCalled = false;
    }

    @Override
    public String run(String value) {
      this.wasCalled = true;
      return super.run(value);
    }

    public Boolean hasBeenCalled() {
      return this.wasCalled;
    }
  }

  @Test
  public void shouldCallTheExtraMethod() {
    ServicePrintString service = new ServicePrintString();
    DecoratorMock mock = new DecoratorMock(service);
    mock.run("some value");
    Assertions.assertTrue(mock.hasBeenCalled());
  }

  @Test
  public void shouldCallWrappedMethod() {
    ServiceMock service = new ServiceMock();
    new DecoratorMock(service).run("test");
    Assertions.assertTrue(service.hasBeenCalled());
  }
}
