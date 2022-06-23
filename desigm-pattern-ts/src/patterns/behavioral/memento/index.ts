interface Memento {
	restore(): void
}
interface Originator {
	save(): Memento
}

export class ConcreteOriginator implements Originator {
	state: string
	constructor(initial: string) {
		this.state = initial
	}
	save(): Memento {
		return new ConcreteMemento(this, this.state)
	}
	setState(state: string) {
		this.state = state
	}
}
export class ConcreteMemento implements Memento {
	originator: ConcreteOriginator
	state: string
	constructor(originator: ConcreteOriginator, initial = "") {
		this.originator = originator
		this.state = initial
	}
	restore(): void {
		this.originator.setState(this.state)
	}
}
