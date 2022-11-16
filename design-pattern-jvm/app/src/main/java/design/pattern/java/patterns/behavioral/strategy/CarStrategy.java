package design.pattern.java.patterns.behavioral.strategy;

public class CarStrategy implements RouteBuilder {
  public String createRoute() {
    return "Car route";
  }
}
