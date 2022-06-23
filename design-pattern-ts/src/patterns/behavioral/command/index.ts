interface Command {
	execute(): void
}
export class FirstCommand implements Command {
	fn: () => void
	constructor(fn: () => void) {
		this.fn = fn
	}
	execute(): void {
		this.fn()
	}
}
export class SecondCommand implements Command {
	param: string
	fn: (name: string) => void
	constructor(param: string, fn: (name: string) => void) {
		this.fn = fn
		this.param = param
	}
	execute(): void {
		this.fn(this.param)
	}
}
