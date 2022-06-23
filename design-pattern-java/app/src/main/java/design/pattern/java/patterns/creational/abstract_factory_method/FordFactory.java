package design.pattern.java.patterns.creational.abstract_factory_method;

public class FordFactory implements VehicleFactory {

  @Override
  public DeportVehicle createDeportCar() {
    return new FordMustang();
  }

  @Override
  public RusticVehicle createRusticCar() {
    return new FordPickup();
  }
  
}
