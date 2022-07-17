package design.pattern.java.patterns.structural.flyweight_cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlyWeightCacheTest {
  class ColorShapeMock extends ColorShape {
    private Boolean wasCalled;

    public ColorShapeMock(String color, String shape) {
      super(color, shape);
    }

    @Override
    public Particle move(Particle context, Number x, Number y) {
      this.wasCalled = true;
      return super.move(context, x, y);
    }

    public Boolean hasBeenCalled() {
      return this.wasCalled;
    }
  }

  @Test
  public void shouldReturnUniqueColorShapeWhenIsNotCached() {
    var uniqueState = new ColorShape("red", "circle");
    var particle = new Particle(1, 1, uniqueState);
    Assertions.assertTrue(particle.getColorShape() == uniqueState);
  }

  @Test
  public void shouldReturnCachedColorShapeWhenIsCached() {
    var uniqueState = new ColorShape("red", "circle");
    var cachedState = new ColorShape("red", "circle");
    new Particle(1, 1, uniqueState);
    var particle2 = new Particle(2, 2, cachedState);
    Assertions.assertTrue(particle2.getColorShape() != uniqueState);
  }

  @Test
  public void shouldCallCachedMethodWhenContextMethodIsCalled() {
    final var uniqueState = new ColorShapeMock("red", "circle");
    final var particle = new Particle(3, 3, uniqueState);
    particle.move(3, 3);
    Assertions.assertTrue(uniqueState.hasBeenCalled());
  }

}
