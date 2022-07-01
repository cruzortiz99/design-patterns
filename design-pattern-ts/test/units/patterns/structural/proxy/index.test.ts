import { Service, ServiceProxy } from "@patterns/structural/proxy"
describe( "Structural Pattern: Proxy", () => {
  it( `
  Should call service's addServicePrefix, 
  when same method in proxy is called`,
    () => {
      const serviceMock = new Service( "test" )
      serviceMock.addServicePrefix = jest.fn()
      new ServiceProxy( serviceMock ).addServicePrefix( "text" )
      expect( serviceMock.addServicePrefix ).toHaveBeenCalled()
    } )
  it( `
  Should call service's addServicePrefix once, 
  when same method in proxy is called several times`,
    () => {
      const serviceMock = new Service( "test" )
      serviceMock.addServicePrefix = jest.fn( () => "test" )
      const proxy = new ServiceProxy( serviceMock )
      proxy.addServicePrefix( "text" )
      proxy.addServicePrefix( "text" )
      proxy.addServicePrefix( "text" )
      expect( serviceMock.addServicePrefix ).toHaveBeenCalledTimes( 1 )
    } )
  it( "Should return cached value when same params is sent through the method",
    () => {
      const proxy = new ServiceProxy( new Service( "service-test" ) )
      const firstResult = proxy.addServicePrefix( "1" )
      const secondResult = proxy.addServicePrefix( "1" )
      const thirdResult = proxy.addServicePrefix( "1" )
      expect( firstResult ).toBe( secondResult )
      expect( firstResult ).toBe( thirdResult )
    } )
} )