package design.pattern.java.patterns.behavioral.chain_responsibility;

import java.util.function.Supplier;

public class Leaf implements ComponentWithHandler {
  private Supplier<Boolean> handler;
  private Container container;

  public Leaf(Supplier<Boolean> handler) {
    this.handler = handler;
    this.container = null;
  }

  @Override
  public void handle() {
    if (this.handler != null) {
      this.handler.get();
    } else if (this.container != null) {
      this.container.handle();
    }
  }

  public void setContainer(Container container) {
    this.container = container;
  }
}