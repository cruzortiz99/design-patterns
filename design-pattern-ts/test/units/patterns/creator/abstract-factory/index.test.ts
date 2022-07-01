import {
	FordExplorer,
	FordFactory,
	FordMustang,
	ToyotaFactory,
	ToyotaForRunner,
	ToyotaYaris,
} from "@patterns/creator/abstract-factory"

describe("Creator pattern: Abstract Factory", () => {
	it(`Should create ford mustang 
	when ford factory produce deport car`, () => {
		const car = new FordFactory().produceDeportCar()
		expect(car).toBeInstanceOf(FordMustang)
	})
	it(`Should ford explorer 
	when ford factory produce rustic car`, () => {
		const car = new FordFactory().produceRusticCar()
		expect(car).toBeInstanceOf(FordExplorer)
	})
	it(`Should create toyota yaris
	when toyota factory produce deport car`, () => {
		const car = new ToyotaFactory().produceDeportCar()
		expect(car).toBeInstanceOf(ToyotaYaris)
	})
	it(`Should create for runner
	when toyota factory produce rustic car`, () => {
		const car = new ToyotaFactory().produceRusticCar()
		expect(car).toBeInstanceOf(ToyotaForRunner)
	})
})
