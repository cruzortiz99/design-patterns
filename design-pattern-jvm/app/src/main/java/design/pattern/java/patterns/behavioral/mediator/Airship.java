package design.pattern.java.patterns.behavioral.mediator;

public class Airship {
  private Mediator controlTower;

  public Airship(Mediator controlTower) {
    this.controlTower = controlTower;
  }

  public void notifyBeforeLand() {
    this.controlTower.notify(this, "beforeLand");
  }

  public void notifyAfterLand() {
    this.controlTower.notify(this, "afterLand");
  }

  public void notifyBeforeLiftOff() {
    this.controlTower.notify(this, "beforeLiftOff");
  }

  public void notifyAfterLiftOff() {
    this.controlTower.notify(this, "afterLiftOff");
  }
}
