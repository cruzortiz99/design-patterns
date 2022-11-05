package design.pattern.java.patterns.behavioral.state;

public record GreenLight() implements TrafficLightState{
  @Override
  public TrafficLightState changeLight() {
    return new YellowLight();
  }
  @Override
  public String trafficAction() {
    return "You can pass now";
  }
}
