package design.pattern.kotlin.patterns.behavioral.state

class TrafficLight(private var state: TrafficLightState = RedLight()) {
  fun changeLight(): TrafficLight {
    this.state = this.state.changeLight()
    return this
  }
  fun trafficAction(): String {
    return this.state.trafficAction()
  }
  fun currentState(): TrafficLightState {
    return this.state
  }
}
