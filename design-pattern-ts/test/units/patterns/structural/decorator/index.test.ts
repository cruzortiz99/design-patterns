import {
LoggerDecorator,ServicePrintString
} from "@src/patterns/structural/decorator"

describe( "Structural Pattern: Decorator", () => {
  it( "Should call the extra method", () => {
    const service = new ServicePrintString()
    const decorator = new LoggerDecorator(service)
    decorator.log = jest.fn(decorator.log)
    decorator.run("test")
    expect(decorator.log).toHaveBeenCalledTimes(1)
  } )
  it( "Should call the wrapped method", () => {
    const service = new ServicePrintString()
    const decorator = new LoggerDecorator(service)
    service.run = jest.fn(service.run)
    decorator.run("test")
    expect(service.run).toHaveBeenCalledTimes(1)
  } )
} )