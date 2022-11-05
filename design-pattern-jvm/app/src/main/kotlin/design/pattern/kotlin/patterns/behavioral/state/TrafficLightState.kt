package design.pattern.kotlin.patterns.behavioral.state

interface TrafficLightState {
  fun changeLight(): TrafficLightState
  fun trafficAction(): String
}
