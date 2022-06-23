import { ConcreteOriginator } from "@patterns/behavioral/memento"

describe("Behavioral Pattern: Memento", () => {
	it("Should restore previous version of the originator", () => {
		const initialState = "first"
		const originator = new ConcreteOriginator(initialState)
		const firstSave = originator.save()
		originator.setState("second")
		expect(originator.state).not.toStrictEqual(initialState)
		firstSave.restore()
		expect(originator.state).toStrictEqual(initialState)
	})
})
