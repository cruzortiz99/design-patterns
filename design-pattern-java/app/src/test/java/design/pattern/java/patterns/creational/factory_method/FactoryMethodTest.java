package design.pattern.java.patterns.creational.factory_method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactoryMethodTest {
  @Test
  public void itShouldCreateSmallCarInstanceWhenSmallCarFactoryIsUsed() {
    CarFactory factory = new SmallCarFactory();
    Car car = factory.produceCar();
    Assertions.assertTrue(car instanceof SmallCar);
  }  
  @Test
  public void itShouldCreateBigCarInstanceWhenBigCarFactoryIsUsed() {
    CarFactory factory = new BigCarFactory();
    Car car = factory.produceCar();
    Assertions.assertTrue(car instanceof BigCar);
  }
}
