import {
	ConcreteFactory1,
	ConcreteFactory2,
	ConcreteProductA1,
	ConcreteProductA2,
	ConcreteProductB1,
	ConcreteProductB2,
} from "@patterns/creator/abstract-factory"

describe( "Creator pattern: Abstract Factory", () => {
	it( "Should create a Product A 1 from abstract factory", () => {
		const productA1 = new ConcreteFactory1().createProductA()
		expect( productA1 ).toBeInstanceOf( ConcreteProductA1 )
	} )
	it( "Should create a Product B 1 from abstract factory", () => {
		const productB1 = new ConcreteFactory1().createProductB()
		expect( productB1 ).toBeInstanceOf( ConcreteProductB1 )
	} )
	it( "Should create a Product A 2 from abstract factory", () => {
		const productA2 = new ConcreteFactory2().createProductA()
		expect( productA2 ).toBeInstanceOf( ConcreteProductA2 )
	} )
	it( "Should create a Product B 2 from abstract factory", () => {
		const productB2 = new ConcreteFactory2().createProductB()
		expect( productB2 ).toBeInstanceOf( ConcreteProductB2 )
	} )
} )
