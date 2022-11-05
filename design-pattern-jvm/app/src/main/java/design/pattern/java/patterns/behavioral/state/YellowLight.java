package design.pattern.java.patterns.behavioral.state;

public record YellowLight() implements TrafficLightState {
  @Override
  public TrafficLightState changeLight() {
    return new RedLight();
  }
  @Override
  public String trafficAction() {
    return "Warning, slow down";
  }
}
