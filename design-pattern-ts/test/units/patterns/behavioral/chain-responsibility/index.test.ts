import {
	ParentElement,
	ChildElement,
} from "@patterns/behavioral/chain-responsibility"
describe("Behavioral Patterns: Chain of Responsibility", () => {
	it("Should handler be called when method handle is called", () => {
		const handlerMock = jest.fn()
		const child = new ChildElement(handlerMock)
		child.handle()
		expect(handlerMock).toHaveBeenCalledTimes(1)
	})
	it("Should call parent handler when no handle is set but called", () => {
		const handlerMock = jest.fn()
		const child = new ChildElement()
		const parent = new ParentElement(handlerMock)
		parent.add(child)
		child.handle()
		expect(handlerMock).toHaveBeenCalledTimes(1)
	})
	it("Should call the higher parent handler method if no one its set", () => {
		const handlerMock = jest.fn()
		const lowerChild = new ChildElement()
		const lowerParent = new ParentElement()
		lowerParent.add(lowerChild)
		const higherParent = new ParentElement(handlerMock)
		higherParent.add(lowerParent)
		lowerChild.handle()
		expect(handlerMock).toHaveBeenCalledTimes(1)
	})
})
