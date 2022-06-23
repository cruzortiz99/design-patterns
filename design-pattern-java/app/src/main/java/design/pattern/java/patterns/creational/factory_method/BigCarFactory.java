package design.pattern.java.patterns.creational.factory_method;

public class BigCarFactory implements CarFactory{
  @Override
  public Car produceCar() {
    return new BigCar();
  }
}