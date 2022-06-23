import { greeting } from "../src"

describe("Init test", () => {
	it("Should say hola mundo", () => {
		console.log = jest.fn()
		greeting()
		expect(console.log).toHaveBeenCalledTimes(1)
	})
})
