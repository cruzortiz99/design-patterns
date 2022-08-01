package design.pattern.java.patterns.behavioral.chain_responsibility;

import java.util.function.Supplier;

public class Container extends Leaf {
  public Container(Supplier<Boolean> handler) {
    super(handler);
  }

  public Container add(Leaf leaf) {
    leaf.setContainer(this);
    return this;
  }

}
