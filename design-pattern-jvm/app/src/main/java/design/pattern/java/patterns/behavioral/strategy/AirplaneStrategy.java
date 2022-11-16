package design.pattern.java.patterns.behavioral.strategy;

public class AirplaneStrategy implements RouteBuilder{
  public String createRoute() {
    return "Airplane route";
  }
}
