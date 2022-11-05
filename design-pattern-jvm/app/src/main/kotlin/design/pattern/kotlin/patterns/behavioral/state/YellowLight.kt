package design.pattern.kotlin.patterns.behavioral.state

class YellowLight() : TrafficLightState {
  override fun changeLight(): TrafficLightState {
    return RedLight()
  }
  override fun trafficAction(): String {
    return "Slow down, warning"
  }
}
