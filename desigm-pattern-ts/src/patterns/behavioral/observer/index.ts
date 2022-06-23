abstract class Observer<T> {
	abstract update(value?: T): void
}
abstract class Publisher<T> {
	private subscribers: Observer<T>[]
	protected value?: T
	constructor(initialState?: T) {
		this.subscribers = []
		this.value = initialState
		this.notify()
	}
	addSubscriber(subscriber: Observer<T>) {
		this.subscribers.push(subscriber)
	}
	removeSubscriber(subscriber: Observer<T>) {
		this.subscribers = this.subscribers.filter(
			(subscribed) => subscribed != subscriber
		)
	}
	notify() {
		this.subscribers.forEach((subscriber) => subscriber.update(this.value))
	}
}

export class ConcreteObserver extends Observer<string> {
	value?: string
	constructor() {
		super()
	}
	update(value: string): void {
		this.value = value
	}
}
export class ConcretePublisher extends Publisher<string> {
	constructor(initialValue?: string) {
		super(initialValue)
	}
	changeValue(newValue: string) {
		this.value = newValue
		this.notify()
	}
}
