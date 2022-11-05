from unittest import TestCase
import patterns.behavioral.state as pattern_state


class StateTest(TestCase):
    def test_should_change_to_red_light_when_yellow_change(self):
        traffic_light = pattern_state.TrafficLight(
            pattern_state.YellowLight())
        obtained_light = traffic_light.change_light().get_current_state()
        self.assertIsInstance(obtained_light, pattern_state.RedLight)

    def test_should_change_to_yellow_light_when_green_change(self):
        traffic_light = pattern_state.TrafficLight(pattern_state.GreenLight())
        obtained_light = traffic_light.change_light().get_current_state()
        self.assertIsInstance(obtained_light, pattern_state.YellowLight)

    def test_should_change_to_green_light_when_red_change(self):
        traffic_light = pattern_state.TrafficLight(pattern_state.RedLight())
        obtained_light = traffic_light.change_light().get_current_state()
        self.assertIsInstance(obtained_light, pattern_state.GreenLight)
