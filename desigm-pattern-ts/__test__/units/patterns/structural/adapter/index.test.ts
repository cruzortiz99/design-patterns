import { AdaptedService, SomeService } from "@src/patterns/structural/adapter"

describe( "Structural Patterns: Adapter Pattern", () => {
  it( "Should call the base service method", () => {
    const mockService: SomeService<string, string> = {
      run: jest.fn()
    }
    new AdaptedService( mockService ).run( "test" )
    expect( mockService.run ).toHaveBeenCalledTimes( 1 )
  } )
} )