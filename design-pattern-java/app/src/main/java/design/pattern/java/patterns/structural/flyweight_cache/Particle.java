package design.pattern.java.patterns.structural.flyweight_cache;

public class Particle {
  private Number x;
  private Number y;
  private ColorShape repeatingState;

  public Particle(Number x, Number y, ColorShape colorShape) {
    this.x = x;
    this.y = y;
    this.repeatingState = colorShape;
  }

  public Particle move(Number x, Number y) {
    return this.repeatingState.move(this, x, y);
  }

  protected Particle setX(Number x) {
    this.x = x;
    return this;
  }

  protected Particle setY(Number y) {
    this.y = y;
    return this;
  }

  public Number getX() {
    return this.x;
  }

  public Number getY() {
    return this.y;
  }
}
