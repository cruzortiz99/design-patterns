import {
	CreatorOfProductA,
	CreatorOfProductB,
	ProductA,
	ProductB,
} from "@patterns/creator/factory-method"

describe( "Creators Pattern: Factory Method", () => {
	it( "Should create element Product A from factory A", () => {
		const productA = new CreatorOfProductA().createProduct()
		expect( productA ).toBeInstanceOf( ProductA )
	} )
	it( "Should create element Product B from factory B", () => {
		const productB = new CreatorOfProductB().createProduct()
		expect( productB ).toBeInstanceOf( ProductB )
	} )
} )
