package design.pattern.kotlin.patterns.behavioral.state

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class StateTest {
  @Test
  fun ShouldChangeToGreenWhenRedChange() {
    val trafficLight = TrafficLight(RedLight())
    val lightObtained = trafficLight.changeLight().currentState()
    Assertions.assertTrue(lightObtained is GreenLight)
  }
  @Test
  fun ShouldChangeToRedWhenYellowChange() {
    val trafficLight = TrafficLight(YellowLight())
    val lightObtained = trafficLight.changeLight().currentState()
    Assertions.assertTrue(lightObtained is RedLight)
  }
  @Test
  fun ShouldChangeToYellowWhenGreenChange() {
    val trafficLight = TrafficLight(GreenLight())
    val lightObtained = trafficLight.changeLight().currentState()
    Assertions.assertTrue(lightObtained is YellowLight)
  }
}
