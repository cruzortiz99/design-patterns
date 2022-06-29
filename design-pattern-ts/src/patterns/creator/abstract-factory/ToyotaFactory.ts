import { DeportCar } from "./DeportCar"
import { RusticCar } from "./RusticCar"
import { VehicleFactory } from "./VehicleFactory"
import { ToyotaYaris } from "./ToyotaYaris"
import { ToyotaForRunner } from "./ToyotaForRunner"

export class ToyotaFactory implements VehicleFactory {
	produceDeportCar(): DeportCar {
		return new ToyotaYaris()
	}
	produceRusticCar(): RusticCar {
		return new ToyotaForRunner()
	}
}
