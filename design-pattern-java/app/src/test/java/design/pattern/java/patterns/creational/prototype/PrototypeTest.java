package design.pattern.java.patterns.creational.prototype;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrototypeTest {
  @Test
  public void shouldCopyValuesWhenCopyIsCalled() {
    Car car = new Car("test");
    Car carCopy = (Car)car.copy();
    Assertions.assertEquals(car.getName(), carCopy.getName());
  }
  @Test
  public void shouldHaveDiferenteReferenceWhenCopyIsCalled() {
    Car car = new Car("test");
    Car carCopy = (Car)car.copy();
    Assertions.assertNotEquals(car, carCopy);
  }
}
