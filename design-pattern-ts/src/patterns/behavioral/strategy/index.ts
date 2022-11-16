export interface RouteBuilder {
  createRoute(): string
}

export class BikeStrategy implements RouteBuilder {
  createRoute(): string {
    return "Bike route"
  }
}
export class CarStrategy implements RouteBuilder {
  createRoute(): string {
    return "Car route"
  }
}
export class AirplaneStrategy implements RouteBuilder {
  createRoute(): string {
    return "Airplane route"
  }
}
export class WalkerStrategy implements RouteBuilder {
  createRoute(): string {
    return "Walking route"
  }
}

export class Map {
  private routeStrategy: RouteBuilder
  constructor(strategy: RouteBuilder) {
    this.routeStrategy = strategy
  }
  public createRoute(): string {
    return this.routeStrategy.createRoute()
  }

  public changeStrategy(newStrategy: RouteBuilder): Map {
    this.routeStrategy = newStrategy
    return this
  }
}
