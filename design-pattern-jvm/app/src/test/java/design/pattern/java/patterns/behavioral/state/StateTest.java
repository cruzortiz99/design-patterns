package design.pattern.java.patterns.behavioral.state;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StateTest {
  @Test
  void ShouldChangeToGreenWhenRedChange() {
    TrafficLight trafficLight = new TrafficLight(new RedLight());
    TrafficLightState lightObtained = trafficLight.changeLight()
      .getCurrentState();
    Assertions.assertTrue(lightObtained instanceof GreenLight);
  }
  @Test
  void ShouldChangeToRedWhenYellowChange() {
    TrafficLight trafficLight = new TrafficLight(new YellowLight());
    TrafficLightState lightObtained = trafficLight.changeLight()
      .getCurrentState();
    Assertions.assertTrue(lightObtained instanceof RedLight);
  }
  @Test
  void ShouldChangeToYellowWhenGreenChange() {
    TrafficLight trafficLight = new TrafficLight(new GreenLight());
    TrafficLightState lightObtained = trafficLight.changeLight()
      .getCurrentState();
    Assertions.assertTrue(lightObtained instanceof YellowLight);
  }
}