package design.pattern.java.patterns.behavioral.mediator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MediatorTest {
  class MockControlTower extends ControlTower {
    private Boolean wasCalled;
    private String args;

    public MockControlTower() {
      this.wasCalled = false;
      this.args = "";
    }

    @Override
    public String notify(Airship airship, String event) {
      this.wasCalled = true;
      this.args = event;
      return super.notify(airship, event);
    }

    public Boolean hasBeenCalledWith(String expected) {
      return this.wasCalled && this.args.equals(expected);
    }

  }

  @Test
  public void should_call_notify_when_airship_emits_event() {
    MockControlTower ct = new MockControlTower();
    new Airship(ct).notifyBeforeLand();
    Assertions.assertTrue(ct.hasBeenCalledWith("beforeLand"));
  }

}
