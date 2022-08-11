package design.pattern.java.patterns.behavioral.chain_responsibility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChainResponsibility {
  class ValueWrapper {
    private Boolean wasCalled;

    public ValueWrapper(Boolean value) {
      this.wasCalled = value;
    }

    public void setValue(Boolean value) {
      this.wasCalled = value;
    }

    public Boolean hasBeenCalled() {
      return this.wasCalled;
    }
  }

  @Test
  public void shouldHandlerBeCalledWhenHandleIsCalled() {
    ValueWrapper wasCalled = new ValueWrapper(false);
    Leaf child = new Leaf(() -> {
      wasCalled.setValue(true);
      return true;
    });
    child.handle();
    Assertions.assertTrue(wasCalled.hasBeenCalled());
  }

  @Test
  public void shouldCallParentHandlerWhenNoHandleIsSetButCalled() {
    ValueWrapper wasCalled = new ValueWrapper(false);
    Leaf child = new Leaf(null);
    Container parent = new Container(() -> {
      wasCalled.setValue(true);
      return true;
    });
    parent.add(child);
    child.handle();
    Assertions.assertTrue(wasCalled.hasBeenCalled());
  }

  @Test
  public void shouldCallTheHigherParentHandlerMethodWhenNoneIsSer() {
    ValueWrapper wasCalled = new ValueWrapper(false);
    Leaf child = new Leaf(null);
    Container lowerParent = new Container(null);
    Container higherParent = new Container(() -> {
      wasCalled.setValue(true);
      return true;
    });
    higherParent.add(lowerParent);
    lowerParent.add(child);
    child.handle();
    Assertions.assertTrue(wasCalled.hasBeenCalled());
  }

}