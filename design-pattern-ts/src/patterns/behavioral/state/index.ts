interface TrafficLightState {
  changeLight(): TrafficLightState
  trafficAction(): string
}

export class RedLight implements TrafficLightState{
  trafficAction(): string {
    return "Can't pass"
  }
  changeLight(): TrafficLightState {
    return new GreenLight()
  }
}
export class YellowLight implements TrafficLightState {
  trafficAction(): string {
    return "Warning reduce speed"
  }
  changeLight(): TrafficLightState {
    return new RedLight()
  }

}

export class GreenLight implements TrafficLightState {
  trafficAction(): string {
    return "You can pass now"
  }
  changeLight(): TrafficLightState {
    return new YellowLight()
  }
}

export class TrafficLight { 
  private state: TrafficLightState
  constructor(initialState?: TrafficLightState) {
    this.state = initialState || new RedLight()
  }
  changeLight(): TrafficLight {
    this.state = this.state.changeLight()
    return this
  }
  currentLight(): TrafficLightState {
    return this.state
  }
}