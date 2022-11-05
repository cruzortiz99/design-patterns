package design.pattern.java.patterns.behavioral.state;

public interface TrafficLightState {
  TrafficLightState changeLight();
  String trafficAction();
}
