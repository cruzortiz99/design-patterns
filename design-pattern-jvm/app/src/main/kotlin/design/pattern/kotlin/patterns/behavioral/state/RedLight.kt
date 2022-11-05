package design.pattern.kotlin.patterns.behavioral.state

class RedLight() : TrafficLightState {
  override fun changeLight(): TrafficLightState {
    return GreenLight()
  }
  override fun trafficAction(): String {
    return "You should stop"
  }
}
