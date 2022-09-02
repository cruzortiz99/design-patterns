package design.pattern.java.patterns.behavioral.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandTest {

  class ServiceMock extends Service {
    private Boolean wasCalled = false;

    @Override
    public void apply(String value) {
      this.wasCalled = true;
      super.apply(value);
    }

    public Boolean hasBeenCalled() {
      return this.wasCalled;
    }
  }

  @Test
  public void shouldCallMethodWhenCommandExecutes() {
    ServiceMock testSrv = new ServiceMock();
    ServiceCommandBuilder testCommand = new ServiceCommandBuilder(testSrv);
    testCommand.setArgs("value").Run();
    Assertions.assertTrue(testSrv.hasBeenCalled());
  }

}
