package design.pattern.java.patterns.creational.builder;

public class CarBuilder {
  private Car car;
  
  private CarBuilder() {
    this.car = new Car();
    this.car.setDoors(2);
    this.car.setMotor("4L");
    this.car.setLts(1.4f);
    this.car.setAc(false);
    this.car.setElectronic(false);
  }
  /**
   * Factory method
   * @return
   */
  public static CarBuilder create() {
    return new CarBuilder();
  }

  /**
   * @param doors the doors to set
   * @return this builder
   */
  public CarBuilder setDoors(Integer doors) {
    this.car.setDoors(doors);
    return this;
  }

  /**
   * @param motor the motor to set
   */
  public CarBuilder setMotor(String motor) {
    this.car.setMotor(motor);
    return this;
  }

  /**
   * @param lts the lts to set
   */
  public CarBuilder setLts(Float lts) {
    this.car.setLts(lts);
    return this;
  }

  /**
   * @param ac the ac to set
   */
  public CarBuilder setAc(Boolean ac) {
    this.car.setAc(ac);
    return this;
  }

  /**
   * @param electronic the electronic to set
   */
  public CarBuilder setElectronic(Boolean electronic) {
    this.car.setElectronic(electronic);
    return this;
  }
  /**
   * 
   * @return Car build
   */
  public Car build() {
    return this.car;
  }
}
