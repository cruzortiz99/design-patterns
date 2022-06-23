import { Component, Composite } from "@src/patterns/structural/composite"

describe( "Structural Pattern: Composite", () => {
  it( "Should delegate the execution to it children", () => {
    const component1: Component = {
      execute: jest.fn()
    }
    const component2: Component = {
      execute: jest.fn()
    }
    new Composite( component1 ).add( component2 ).execute()
    expect( component1.execute ).toHaveBeenCalledTimes( 1 )
    expect( component2.execute ).toHaveBeenCalledTimes( 1 )
  } )
} )