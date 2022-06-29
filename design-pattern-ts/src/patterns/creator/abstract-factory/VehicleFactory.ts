import { DeportCar } from "./DeportCar"
import { RusticCar } from "./RusticCar"

export interface VehicleFactory {
	produceDeportCar(): DeportCar
	produceRusticCar(): RusticCar
}
