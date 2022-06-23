import { FirstCommand, SecondCommand } from "@patterns/behavioral/command"
describe("Behavioral Pattern: Command", () => {
	it("Should call method when FirstCommand executes", () => {
		const testFn = jest.fn()
		const command = new FirstCommand(testFn)
		command.execute()
		expect(testFn).toHaveBeenCalledTimes(1)
	})
	it("Should call method when SecondCommand executes with params", () => {
		const testFn = jest.fn((name: string) => undefined)
		const command = new SecondCommand("test", testFn)
		command.execute()
		expect(testFn).toHaveBeenCalledTimes(1)
		expect(testFn).toHaveBeenCalledWith("test")
	})
})
