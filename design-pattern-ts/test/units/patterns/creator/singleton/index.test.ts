import { DBConnection } from "@src/patterns/creator/singleton"

describe( "Creator Pattern: Singleton", () => {
  it( "Should create one instance when create is called", () => {
    const host = "test.com"
    const port = 8443
    const username = "test"
    const password = "****"
    const connection = DBConnection.create( host, port, username, password )
    expect( connection.getHost() ).toBe( host )
    expect( connection.getPort() ).toBe( port )
    expect( connection.getUsername() ).toBe( username )
    expect( connection.getPassword() ).toBe( password )
  } )
  it( `Should create only one instance 
  when create is called more than once`, () => {
    const host = "test.com"
    const port = 8443
    const username = "test"
    const password = "****"
    const connection = DBConnection.create( host, port, username, password )
    Array.of( 1, 2, 3 ).map( ( index ) => DBConnection.create(
      host, port + index, username.concat( `${index}` ), password
    ) ).forEach( ( dBConnection ) => {
      expect( dBConnection ).toBe( connection )
    } )
  } )
} )