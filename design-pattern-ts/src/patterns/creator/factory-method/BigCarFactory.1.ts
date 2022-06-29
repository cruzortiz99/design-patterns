export class BigCarFactory implements CarFactory {
	createCar(): Car {
		return new BigCar()
	}
}
