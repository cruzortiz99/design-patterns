interface Product {
	a: number
	b: string
	c: number
}
export class Product1 implements Product {
	a: number
	b: string
	c: number
	constructor () {
		this.a = 0
		this.b = ""
		this.c = 0
	}
}
interface Builder<T extends Product> {
	reset (): void
	buildStepA ( value: number ): Builder<T>
	buildStepB ( value: string ): Builder<T>
	buildStepC ( value: number ): Builder<T>
	getProduct (): T
}
export class BuilderA implements Builder<Product1> {
	result: Product1
	constructor () {
		this.result = new Product1()
	}
	reset (): void {
		this.result = new Product1()
	}
	buildStepA ( value: number ): Builder<Product1> {
		this.result.a = value
		return this
	}
	buildStepB ( value: string ): Builder<Product1> {
		this.result.b = value
		return this
	}
	buildStepC ( value: number ): Builder<Product1> {
		this.result.c = value
		return this
	}
	getProduct (): Product1 {
		return this.result
	}
}
