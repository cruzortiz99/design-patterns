import { 
  GreenLight, 
  RedLight, 
  TrafficLight, 
  YellowLight} from "@src/patterns/behavioral/state"

describe("State Pattern", () => {
  test("Should change state to GreenLight when is in RedLight", () => {
    const trafficLight = new TrafficLight(new RedLight())
    const obtainedTrafficLight = trafficLight.changeLight().currentLight()
    expect(obtainedTrafficLight).toBeInstanceOf(GreenLight)

  })
  test("Should change state to YellowLight when is in GreenLight", () => {
    const trafficLight = new TrafficLight(new GreenLight())
    const obtainedTrafficLight = trafficLight.changeLight().currentLight()
    expect(obtainedTrafficLight).toBeInstanceOf(YellowLight)
  })
  test("Should change state to RedLight when is in YellowLight", () => {
    const trafficLight = new TrafficLight(new YellowLight())
    const obtainedTrafficLight = trafficLight.changeLight().currentLight()
    expect(obtainedTrafficLight).toBeInstanceOf(RedLight)
  })
})