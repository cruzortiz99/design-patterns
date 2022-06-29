import { BigCar } from "./BigCar"
import { Car } from "./Car"
import { CarFactory } from "./CarFactory"

export class BigCarFactory implements CarFactory {
	createCar(): Car {
		return new BigCar()
	}
}
