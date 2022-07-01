import { Car } from "@patterns/creator/prototype"

describe("Creators Pattern: Prototype", () => {
	it(`Should copy the values from a car to another
  when copy its call`, () => {
		const car = new Car("test")
		const carCopy = car.copy() as Car
		expect(carCopy.name).toBe(car.name)
	})
	it("Should have different reference when copy", () => {
		const car = new Car("test")
		const carCopy = car.copy()
		expect(car).not.toBe(carCopy)
	})
})
