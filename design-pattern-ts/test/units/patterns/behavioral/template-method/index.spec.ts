import { DataReaderTemplate } from "@src/patterns/behavioral/template-method"

describe("Strategy Pattern:", () => {
  test("Should allow to change the inner value when map is called", () => {
    const data = ["test", "test"]
    const dataReader = new DataReaderTemplate(() => data)
    const dataReaderMapped = dataReader
      .map((data, key) => `${data} mapped ${key}`)
    data.map((data, key) => `${data} mapped ${key}`).forEach((mapped, key) => {
      expect(dataReaderMapped.get()[key]).toBe(mapped)
    })
  })
  test("Should allow to filter the inner value when filter is called", 
  () => {
    const data = ["test", "test"]
    const dataReader = new DataReaderTemplate(() => data)
    const dataReaderFiltered = dataReader
      .filter((_, key) => key > 0)
    expect(dataReaderFiltered.get().length).toBeLessThan(data.length)
  })
  test("Should allow to reduce to the inner value when reduce is called", 
  () => {
    const data = ["test", "test"]
    const dataReader = new DataReaderTemplate(() => data)
    const dataReaderReduced = dataReader
      .reduce((_, data) => `${data} reduced`, "")
    expect(dataReaderReduced.get()[0])
      .toBe(data.reduce((_, data) => `${data} reduced`, ""))
  })
})