package design.pattern.java.patterns.creational.abstract_factory_method;

public interface VehicleFactory {
  DeportVehicle createDeportCar();
  RusticVehicle createRusticCar();
}
