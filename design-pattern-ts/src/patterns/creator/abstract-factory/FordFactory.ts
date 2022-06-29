import { DeportCar } from "./DeportCar"
import { RusticCar } from "./RusticCar"
import { VehicleFactory } from "./VehicleFactory"
import { FordMustang } from "./FordMustang"
import { FordExplorer } from "./FordExplorer"

export class FordFactory implements VehicleFactory {
	produceDeportCar(): DeportCar {
		return new FordMustang()
	}
	produceRusticCar(): RusticCar {
		return new FordExplorer()
	}
}
