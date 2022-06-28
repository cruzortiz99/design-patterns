package design.pattern.java.patterns.creational.builder;

public class Car {
  private Integer doors;
  private String motor;
  private Float lts;
  private Boolean ac;
  private Boolean electronic;

  Car() {}

  /**
   * @return the doors
   */
  public Integer getDoors() {
    return doors;
  }

  /**
   * @param doors the doors to set
   */
  public void setDoors(Integer doors) {
    this.doors = doors;
  }

  /**
   * @return the motor
   */
  public String getMotor() {
    return motor;
  }

  /**
   * @param motor the motor to set
   */
  public void setMotor(String motor) {
    this.motor = motor;
  }

  /**
   * @return the lts
   */
  public Float getLts() {
    return lts;
  }

  /**
   * @param lts the lts to set
   */
  public void setLts(Float lts) {
    this.lts = lts;
  }

  /**
   * @return the ac
   */
  public Boolean getAc() {
    return ac;
  }

  /**
   * @param ac the ac to set
   */
  public void setAc(Boolean ac) {
    this.ac = ac;
  }

  /**
   * @return the electronic
   */
  public Boolean getElectronic() {
    return electronic;
  }

  /**
   * @param electronic the electronic to set
   */
  public void setElectronic(Boolean electronic) {
    this.electronic = electronic;
  }
  
}
