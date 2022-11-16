package design.pattern.java.patterns.behavioral.strategy;

public class BikeStrategy implements RouteBuilder{
  public String createRoute() {
    return "Bike route";
  }
}
