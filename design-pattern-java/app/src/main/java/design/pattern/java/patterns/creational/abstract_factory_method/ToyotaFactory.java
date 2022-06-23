package design.pattern.java.patterns.creational.abstract_factory_method;

public class ToyotaFactory implements VehicleFactory{

  @Override
  public DeportVehicle createDeportCar() {
    return new ToyotaYaris();
  }

  @Override
  public RusticVehicle createRusticCar() {
    return new ToyotaForRunner();
  }
  
}
