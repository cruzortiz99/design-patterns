import { Car } from "./Car"
import { CarFactory } from "./CarFactory"
import { SmallCar } from "./SmallCar"

export class SmallCarFactory implements CarFactory {
	createCar(): Car {
		return new SmallCar()
	}
}
