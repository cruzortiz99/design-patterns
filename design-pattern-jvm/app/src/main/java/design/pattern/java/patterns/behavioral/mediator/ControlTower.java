package design.pattern.java.patterns.behavioral.mediator;

public class ControlTower implements Mediator {

  @Override
  public String notify(Airship airship, String event) {
    switch (event) {
      case "beforeLand":
        return "preparing to land";
      case "afterLand":
        return "preparing for passangers unboarding";
      case "afterLiftOff":
        return "cleaning up route to other airship";
      default:
        return "preparing route to lift off";
    }
  }
}
