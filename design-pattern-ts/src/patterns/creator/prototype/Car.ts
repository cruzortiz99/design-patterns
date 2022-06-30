import { CarPrototype } from "./CarPrototype"

export class Car implements CarPrototype {
	name: string
	constructor(name: string) {
		this.name = name
	}
	copy(): CarPrototype {
		return new Car(this.name)
	}
}
