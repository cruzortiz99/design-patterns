export abstract class ProductA { }
export abstract class ProductB { }

export class ConcreteProductA1 extends ProductA { }
export class ConcreteProductA2 extends ProductA { }

export class ConcreteProductB1 extends ProductB { }
export class ConcreteProductB2 extends ProductB { }

export interface AbstractFactory {
	createProductA (): ProductA
	createProductB (): ProductB
}

export class ConcreteFactory1 implements AbstractFactory {
	createProductA (): ProductA {
		return new ConcreteProductA1()
	}
	createProductB (): ProductB {
		return new ConcreteProductB1()
	}
}
export class ConcreteFactory2 implements AbstractFactory {
	createProductA (): ProductA {
		return new ConcreteProductA2()
	}
	createProductB (): ProductB {
		return new ConcreteProductB2()
	}
}
