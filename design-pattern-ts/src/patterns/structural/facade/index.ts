interface Component {
  execute ( value: string ): string
}
export class SomeLibrary implements Component {
  execute ( value: string ): string {
    return value.concat( " from some library" )
  }
}
export class OtherLibrary implements Component {
  execute ( value: string ): string {
    return value.concat( "from other library" )
  }
}

export class FacadeService {
  feature ( value: string ): string {
    return new OtherLibrary().execute( new SomeLibrary().execute( value ) )
  }
}