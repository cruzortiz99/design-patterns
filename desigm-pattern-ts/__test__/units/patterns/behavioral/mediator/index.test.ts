import {
	ConcreteMediator,
	ComponentA,
	ComponentB,
	ComponentC,
} from "@patterns/behavioral/mediator"

describe("Behavioral Pattern: Mediator", () => {
	it("Should call reactOnA when click is emitted from componentA", () => {
		const componentA = new ComponentA()
		const componentB = new ComponentB()
		const componentC = new ComponentC()
		const wrapper = new ConcreteMediator(componentA, componentB, componentC)
		wrapper.reactOnA = jest.fn()
		componentA.click()
		expect(wrapper.reactOnA).toHaveBeenCalledTimes(1)
	})
	it("Should call reactOnA when keyPress is emitted from componentA", () => {
		const componentA = new ComponentA()
		const componentB = new ComponentB()
		const componentC = new ComponentC()
		const wrapper = new ConcreteMediator(componentA, componentB, componentC)
		wrapper.reactOnA = jest.fn()
		componentA.keyPress()
		expect(wrapper.reactOnA).toHaveBeenCalledTimes(1)
	})
	it("Should call reactOnB when resize is emitted from componentB", () => {
		const componentA = new ComponentA()
		const componentB = new ComponentB()
		const componentC = new ComponentC()
		const wrapper = new ConcreteMediator(componentA, componentB, componentC)
		wrapper.reactOnB = jest.fn()
		componentB.resize()
		expect(wrapper.reactOnB).toHaveBeenCalledTimes(1)
	})
	it("Should call reactOnB when move is emitted from componentB", () => {
		const componentA = new ComponentA()
		const componentB = new ComponentB()
		const componentC = new ComponentC()
		const wrapper = new ConcreteMediator(componentA, componentB, componentC)
		wrapper.reactOnB = jest.fn()
		componentB.move()
		expect(wrapper.reactOnB).toHaveBeenCalledTimes(1)
	})
	it("Should call reactOnA when show is emitted from componentC", () => {
		const componentA = new ComponentA()
		const componentB = new ComponentB()
		const componentC = new ComponentC()
		const wrapper = new ConcreteMediator(componentA, componentB, componentC)
		wrapper.reactOnC = jest.fn()
		componentC.show()
		expect(wrapper.reactOnC).toHaveBeenCalledTimes(1)
	})
})
