import {
	ConcreteObserver,
	ConcretePublisher,
} from "@patterns/behavioral/observer"

describe("Behavioral Pattern: Observer", () => {
	it("Should notify the observers when updates value", () => {
		const observable = new ConcretePublisher()
		const observer = new ConcreteObserver()
		observer.update = jest.fn()
		observable.addSubscriber(observer)
		const newValue = "newValue"
		observable.changeValue(newValue)
		expect(observer.update).toHaveBeenCalledTimes(1)
		expect(observer.update).toHaveBeenCalledWith(newValue)
	})
	it("Should unsubscribe the observer when removes is call", () => {
		const observable = new ConcretePublisher()
		const observer = new ConcreteObserver()
		observer.update = jest.fn()
		observable.addSubscriber(observer)
		observable.removeSubscriber(observer)
		const newValue = "newValue"
		observable.changeValue(newValue)
		expect(observer.update).not.toHaveBeenCalled()
	})
})
