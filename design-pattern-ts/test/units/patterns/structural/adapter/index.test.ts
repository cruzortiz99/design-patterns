import { 
  AdapterNumToString, 
  ServicePrintString } from "@src/patterns/structural/adapter"

describe( "Structural Patterns: Adapter Pattern", () => {
  it("Should return msg when service is called", () => {
    const inputService = "test"
    const service = new ServicePrintString()
    const result = service.run(inputService)
    expect(result).not.toStrictEqual(inputService)
    expect(result.endsWith(inputService)).toBeTruthy()
  })
  it("Should return msg when adapter is called", () => {
    const inputService = 1234
    const service = new AdapterNumToString(new ServicePrintString())
    const result = service.run(inputService)
    expect(result).not.toStrictEqual(inputService)
    expect(result.endsWith(`${inputService}`)).toBeTruthy()
  })
} )