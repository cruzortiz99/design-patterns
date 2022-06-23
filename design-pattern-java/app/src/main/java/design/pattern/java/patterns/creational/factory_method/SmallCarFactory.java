package design.pattern.java.patterns.creational.factory_method;


public class SmallCarFactory implements CarFactory {
  @Override
  public Car produceCar() {
    return new SmallCar();
  }
}