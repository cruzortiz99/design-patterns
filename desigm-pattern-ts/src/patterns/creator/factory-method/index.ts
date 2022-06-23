interface Product {
	doStuff(): void
}

export class ProductA implements Product {
	doStuff(): void {
		console.log("product A")
	}
}
export class ProductB implements Product {
	doStuff(): void {
		console.log("product B")
	}
}

abstract class Creator {
	someOperation(): void {
		console.log("common creation method")
	}
	abstract createProduct(): Product
}

export class CreatorOfProductA extends Creator {
	createProduct(): Product {
		return new ProductA()
	}
}

export class CreatorOfProductB extends Creator {
	createProduct(): Product {
		return new ProductB()
	}
}
