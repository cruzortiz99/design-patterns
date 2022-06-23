interface ComponentWithHandler {
	handle(): void
}
abstract class Component implements ComponentWithHandler {
	protected handler: (() => void) | undefined
	private container: Container | undefined
	handle(): void {
		if (this.handler) {
			this.handler()
		} else {
			this.container?.handle()
		}
	}
	setContainer(container: Container) {
		this.container = this.container ? this.container : container
	}
}
abstract class Container extends Component {
	protected children: Component[] = []
	add(component: Component) {
		component.setContainer(this)
		this.children.push(component)
	}
}
export class ChildElement extends Component {
	constructor(handler?: () => void) {
		super()
		this.handler = handler
	}
	handle(): void {
		if (this.handler) {
			this.handler()
		} else {
			super.handle()
		}
	}
}
export class ParentElement extends Container {
	constructor(handler?: () => void) {
		super()
		this.handler = handler
	}
	handle(): void {
		if (this.handler) {
			this.handler()
		} else {
			super.handle()
		}
	}
}
