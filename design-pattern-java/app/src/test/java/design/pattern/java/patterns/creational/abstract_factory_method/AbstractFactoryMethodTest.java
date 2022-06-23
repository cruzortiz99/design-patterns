package design.pattern.java.patterns.creational.abstract_factory_method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AbstractFactoryMethodTest {
  @Test
  public void itShouldCreateFordMustangWhenIsRequestedFromFordFactory() {
    VehicleFactory factory = new FordFactory();
    DeportVehicle car = factory.createDeportCar();
    Assertions.assertTrue(car instanceof FordMustang);
  }
  @Test
  public void itShouldCreateFordPickUpWhenIsRequestedFromFordFactory() {
    VehicleFactory factory = new FordFactory();
    RusticVehicle car = factory.createRusticCar();
    Assertions.assertTrue(car instanceof FordPickup);
  }
  @Test
  public void itShouldCreateToyotaYarisWhenIsRequestedFromToyotaFactory() {
    VehicleFactory factory = new ToyotaFactory();
    DeportVehicle car = factory.createDeportCar();
    Assertions.assertTrue(car instanceof ToyotaYaris);
  }
  @Test
  public void itShouldCreateForRunnerWhenIsRequestedFromToyotaFactory() {
    VehicleFactory factory = new ToyotaFactory();
    RusticVehicle car = factory.createRusticCar();
    Assertions.assertTrue(car instanceof ToyotaForRunner);
  }
}
