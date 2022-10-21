package design.pattern.java.patterns.structural.flyweight_cache;

public class ColorShape {
  protected final String color;
  protected final String shape;

  public ColorShape(String color, String shape) {
    this.color = color;
    this.shape = shape;
  }

  public Particle move(Particle context, Number x, Number y) {
    return context.setX(x).setY(y);
  }
}
