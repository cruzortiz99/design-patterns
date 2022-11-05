package design.pattern.java.patterns.behavioral.state;

public class TrafficLight {
  private TrafficLightState state;
  public TrafficLight(TrafficLightState initialState) {
    this.state = initialState == null ? new RedLight() : initialState;
  }
  public TrafficLight changeLight() {
    this.state = this.state.changeLight();
    return this;
  }
  public String trafficAction() {
    return this.state.trafficAction();
  }
  public TrafficLightState getCurrentState() {
    return this.state;
  }
}
