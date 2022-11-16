package design.pattern.java.patterns.behavioral.strategy;

public class Map {
  private RouteBuilder strategy;
  public Map(RouteBuilder strategy) {
    this.strategy = strategy;
  }
  public String createRoute() {
    return this.strategy.createRoute();
  }
  public Map changeStrategy(RouteBuilder strategy) {
    this.strategy = strategy;
    return this;
  }
}
