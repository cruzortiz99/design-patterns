import { main } from "../src"

describe("Init test", () => {
	it("Should say hola mundo", () => {
		console.log = jest.fn()
		main("test")
		expect(console.log).toHaveBeenCalledTimes(1)
	})
})
