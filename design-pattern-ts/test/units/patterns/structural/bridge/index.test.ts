import {
  BridgeConcreteLibrary, SomeLibraryInterface
} from "@src/patterns/structural/bridge"

describe( "Structural Pattern: Bridge Pattern", () => {
  it( "Should call libraries methods", () => {
    const libraryMock: SomeLibraryInterface = {
      method1: jest.fn(),
      method2: jest.fn(),
      method3: jest.fn()
    }
    new BridgeConcreteLibrary( libraryMock ).feature()
    expect( libraryMock.method1 ).toHaveBeenCalledTimes( 1 )
    expect( libraryMock.method2 ).toHaveBeenCalledTimes( 1 )
  } )
} )