import { Map, RouteBuilder } from "@src/patterns/behavioral/strategy"

describe("Strategy Pattern:", () => {
  class MockRoute implements RouteBuilder {
    private wasCalled: boolean
    constructor() {
      this.wasCalled = false
    }
    createRoute(): string {
      this.wasCalled = true
      return ""
    }
    hasBeenCalled(): boolean {
      return this.wasCalled
    }
  }
  test("Should run the strategy set When Create Route Is Called", () => {
    const mockRouteBuilder = new MockRoute()
    const map = new Map(mockRouteBuilder)
    map.createRoute()
    expect(mockRouteBuilder.hasBeenCalled()).toBeTruthy()
  })
})