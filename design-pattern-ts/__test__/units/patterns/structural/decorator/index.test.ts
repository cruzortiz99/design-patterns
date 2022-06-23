import {
  Component,
  ConcreteDecorator
} from "@src/patterns/structural/decorator"

describe( "Structural Pattern: Decorator", () => {
  it( "Should call the extra method", () => {
    const component: Component = {
      execute: jest.fn()
    }
    const decorator: ConcreteDecorator = {
      wrapped: component,
      extra: jest.fn(),
      execute () {
        this.wrapped.execute()
        this.extra()
      }
    }
    decorator.execute()
    expect( decorator.extra ).toBeCalledTimes( 1 )
  } )
  it( "Should call the wrapped method", () => {
    const component: Component = {
      execute: jest.fn()
    }
    const decorator: ConcreteDecorator = {
      wrapped: component,
      extra: jest.fn(),
      execute () {
        this.wrapped.execute()
        this.extra()
      }
    }
    decorator.execute()
    expect( component.execute ).toBeCalledTimes( 1 )
  } )
} )