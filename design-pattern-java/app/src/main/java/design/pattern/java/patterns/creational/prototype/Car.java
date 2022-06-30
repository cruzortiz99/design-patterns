package design.pattern.java.patterns.creational.prototype;

public class Car implements CarPrototype{
  private String name;
  
  public Car(String name) {
    super();
    this.name = name;
  }

  @Override
  public CarPrototype copy() {
    return new Car(this.name);
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
