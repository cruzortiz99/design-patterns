package design.pattern.kotlin.patterns.behavioral.state

class GreenLight() : TrafficLightState {
  override fun changeLight(): TrafficLightState {
    return YellowLight()
  }
  override fun trafficAction(): String {
    return "You can pass now"
  }
}
