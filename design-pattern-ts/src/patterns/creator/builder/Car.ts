export class Car {
	doors: number
	motor: string
	lts: number
	ac: boolean
	electronics: boolean
	constructor(
		doors: number,
		motor: string,
		lts: number,
		ac: boolean,
		electronics: boolean
	) {
		this.doors = doors
		this.motor = motor
		this.lts = lts
		this.ac = ac
		this.electronics = electronics
	}
}
