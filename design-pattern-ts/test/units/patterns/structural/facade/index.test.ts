import { FacadeService } from "@src/patterns/structural/facade"

describe( "Structural Pattern: Facade", () => {
  it( "Should return a processed string by SomeLibrary", () => {
    const obtained = new FacadeService().feature( "some string" )
    expect( obtained ).toMatch( RegExp( "some library", "i" ) )
  } )
  it( "Should return a processed string by OtherLibrary", () => {
    const obtained = new FacadeService().feature( "some string" )
    expect( obtained ).toMatch( RegExp( "other library", "i" ) )
  } )
} )