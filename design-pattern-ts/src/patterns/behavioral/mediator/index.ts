interface Mediator {
	notify(sender: Component, eventName: string): void
}
abstract class Component {
	mediator?: Mediator
	setMediator(mediator: Mediator) {
		this.mediator = mediator
	}
}
export class ComponentA extends Component {
	constructor() {
		super()
	}
	click() {
		this.mediator?.notify(this, "click")
	}
	keyPress() {
		this.mediator?.notify(this, "keyPress")
	}
}
export class ComponentB extends Component {
	constructor() {
		super()
	}
	resize() {
		this.mediator?.notify(this, "resize")
	}
	move() {
		this.mediator?.notify(this, "move")
	}
}
export class ComponentC extends Component {
	constructor() {
		super()
	}
	show() {
		this.mediator?.notify(this, "show")
	}
}
export class ConcreteMediator implements Mediator {
	private component1: Component
	private component2: Component
	private component3: Component
	constructor(
		component1: Component,
		component2: Component,
		component3: Component
	) {
		this.component1 = component1
		this.component2 = component2
		this.component3 = component3
		this.component1.setMediator(this)
		this.component2.setMediator(this)
		this.component3.setMediator(this)
	}
	notify(sender: Component, eventName: string): void {
		if (sender instanceof ComponentA) return this.reactOnA(eventName)
		if (sender instanceof ComponentB) return this.reactOnB(eventName)
		if (sender instanceof ComponentC) return this.reactOnC(eventName)
	}
	reactOnA(eventName: string) {
		console.log(eventName)
	}
	reactOnB(eventName: string) {
		console.log(eventName)
	}
	reactOnC(eventName: string) {
		console.log(eventName)
	}
}
