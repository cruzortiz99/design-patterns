package design.pattern.java.patterns.behavioral.state;

public record RedLight() implements TrafficLightState {
  @Override
  public TrafficLightState changeLight() {
    return new GreenLight();
  }
  @Override
  public String trafficAction() {
    return "Stop can't pass";
  }
}
