import {
  ColorShape,
  Particle
} from "@src/patterns/structural/flyweight-cache"

describe( "Structural Pattern: Flyweight-Cache", () => {
  it( "Should return a unique ColorShape when is not cached", () => {
    const uniqueState = new ColorShape( "red", "circle" )
    const particle1 = new Particle( 0, 0, uniqueState )
    expect( particle1.repeatingState ).toBe( uniqueState )
  } )
  it( "Should return a cached ColorShape when is cached", () => {
    const uniqueState = new ColorShape( "red", "square" )
    const cachedState = new ColorShape( "red", "square" )
    new Particle( 0, 0, uniqueState )
    const particle2 = new Particle( 1, 1, cachedState )
    expect( particle2.repeatingState ).not.toBe( cachedState )
  } )
  it( "Should call cached method when context method is call(optional)",
    () => {
      const uniqueState = new ColorShape(
        Symbol().toString(), Symbol().toString() )
      const particle = new Particle( 0, 0, uniqueState )
      particle.move( 1, 1 )
      expect( uniqueState.move ).toHaveBeenCalledTimes( 1 )
    } )
} )