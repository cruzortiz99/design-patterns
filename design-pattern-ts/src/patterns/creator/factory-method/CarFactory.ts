import { Car } from "./Car"

export interface CarFactory {
	createCar(): Car
}
