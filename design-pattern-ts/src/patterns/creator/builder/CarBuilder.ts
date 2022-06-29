import { Car } from "./Car"

export class CarBuilder {
	private car: Car
	static create(): CarBuilder {
		return new CarBuilder()
	}
	private constructor() {
		this.car = new Car(2, "4L", 1.4, false, false)
	}
	setDoors(doors: number): CarBuilder {
		this.car.doors = doors
		return this
	}
	setMotor(motor: string): CarBuilder {
		this.car.motor = motor
		return this
	}
	setLts(lts: number): CarBuilder {
		this.car.lts = lts
		return this
	}
	setAc(ac: boolean): CarBuilder {
		this.car.ac = ac
		return this
	}
	setElectronics(electronics: boolean): CarBuilder {
		this.car.electronics = electronics
		return this
	}
	build(): Car {
		return this.car
	}
}
