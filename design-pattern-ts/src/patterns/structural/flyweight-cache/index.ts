interface FlyweightState { }
interface Context {
  repeatingState: FlyweightState
}

interface FlyweightFactory<I extends FlyweightState> {
  getFlyweightState ( state: I ): I
}
// --- Implementation
export class ColorShape implements FlyweightState {
  color: string
  shape: string
  constructor ( color: string, shape: string ) {
    this.color = color
    this.shape = shape
  }
  move = jest.fn( ( context: Particle, x: number, y: number ) => {
    context.x = x
    context.y = y
    return context
  } )
}
export class ParticleCacheFactory implements FlyweightFactory<ColorShape> {
  private cache: ColorShape[]
  constructor ( state?: ColorShape ) {
    this.cache = []
    if ( state ) {
      this.cache.push( state )
    }
  }
  getFlyweightState ( state: ColorShape ): ColorShape {
    const cachedState = this.cache
      .filter(
        ( cachedState ) =>
          cachedState.color === state.color && cachedState.shape === state.shape
      )
      .reduce<ColorShape | undefined>(
        ( acc, current ) => acc || current,
        undefined
      )
    if ( !cachedState ) {
      this.cache.push( state )
      return state
    }
    return cachedState
  }
}
export const GLOBAL_PARTICLE_CACHE = new ParticleCacheFactory()

export class Particle implements Context {
  x: number
  y: number
  repeatingState: ColorShape
  constructor ( x: number, y: number, colorShape: ColorShape ) {
    this.x = x
    this.y = y
    this.repeatingState = GLOBAL_PARTICLE_CACHE.getFlyweightState( colorShape )
  }
  move ( x: number, y: number ): Particle {
    return this.repeatingState.move( this, x, y )
  }
}
