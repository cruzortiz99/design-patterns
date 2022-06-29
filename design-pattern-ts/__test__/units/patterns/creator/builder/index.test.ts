import { CarBuilder } from "@patterns/creator/builder"

describe("Creator Pattern: Builder", () => {
	it("Should build a Car with the right values when build its called", () => {
		const doorsExpected = 4
		const motorExpected = "6V"
		const ltsExpected = 1.4
		const acExpected = true
		const electronicsExpected = true
		const car = CarBuilder.create()
			.setDoors(doorsExpected)
			.setMotor(motorExpected)
			.setLts(ltsExpected)
			.setAc(acExpected)
			.setElectronics(electronicsExpected)
			.build()
		expect(car.doors).toBe(doorsExpected)
		expect(car.motor).toBe(motorExpected)
		expect(car.lts).toBe(ltsExpected)
		expect(car.ac).toBe(acExpected)
		expect(car.electronics).toBe(electronicsExpected)
	})
})
