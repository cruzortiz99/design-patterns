import {
  ServiceBridge, SomeLibraryInterface
} from "@src/patterns/structural/bridge"

describe( "Structural Pattern: Bridge Pattern", () => {
  it( "Should call lib method when bridge feature is called", () => {
    const someLibraryMock: SomeLibraryInterface = {
      writeString: jest.fn(() => ""),
      writeOtherString: jest.fn(()=>""),
      integerGenerator: jest.fn(()=> 5)
    }
    const bridge = new ServiceBridge(someLibraryMock)
    bridge.concreteFeature()
    expect(someLibraryMock.writeString).toHaveBeenCalledTimes(1)
    expect(someLibraryMock.writeOtherString).toHaveBeenCalledTimes(1)
    expect(someLibraryMock.integerGenerator).toHaveBeenCalledTimes(1)
  } )
} )