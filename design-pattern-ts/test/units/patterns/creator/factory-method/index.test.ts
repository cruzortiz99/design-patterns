import {
	SmallCarFactory,
	BigCarFactory,
	SmallCar,
	BigCar,
} from "@patterns/creator/factory-method"

describe("Creators Pattern: Factory Method", () => {
	it("Should create small car when small car factory produce car", () => {
		const productA = new SmallCarFactory().createCar()
		expect(productA).toBeInstanceOf(SmallCar)
	})
	it("Should create big car when big car factory produce car", () => {
		const productB = new BigCarFactory().createCar()
		expect(productB).toBeInstanceOf(BigCar)
	})
})
