import { SingleInstance } from "@src/patterns/creator/singleton"

describe( "Creator Pattern: Singleton", () => {
  it( "Should create a SingleInstance object", () => {
    expect( SingleInstance.instance ).toBeInstanceOf( SingleInstance )

  } )
  it( "Should always have access to the same instance", () => {
    const ref1 = SingleInstance.instance
    const ref2 = SingleInstance.instance
    ref2.value = "test"
    const ref3 = SingleInstance.instance
    expect( ref1 ).toBe( ref2 )
    expect( ref1 ).toBe( ref3 )
  } )
} )