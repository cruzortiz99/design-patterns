import { BuilderA, Product1 } from "@patterns/creator/builder"

describe( "Creator Pattern: Builder", () => {
	it( "Should get a product", () => {
		const product = new BuilderA().getProduct()
		expect( product ).toBeInstanceOf( Product1 )
	} )
	it( "Should set the value on stepA", () => {
		const valueExpected = 151
		const product = new BuilderA().buildStepA( valueExpected ).getProduct()
		expect( product.a ).toBe( valueExpected )
	} )
	it( "Should set the value on stepB", () => {
		const valueExpected = "test"
		const product = new BuilderA().buildStepB( valueExpected ).getProduct()
		expect( product.b ).toBe( valueExpected )
	} )
	it( "Should set the value on stepC", () => {
		const valueExpected = 150
		const product = new BuilderA().buildStepC( valueExpected ).getProduct()
		expect( product.c ).toBe( valueExpected )
	} )
} )
