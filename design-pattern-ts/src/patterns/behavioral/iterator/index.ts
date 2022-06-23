interface Iterator<T> {
	hasNext(): boolean
	next(): T
}

interface Iterable<T> {
	getIterator(): Iterator<T>
}

class ConcreteIterator implements Iterator<[string, number]> {
	private iterable: ConcreteIterable
	private index: number
	constructor(iterable: ConcreteIterable) {
		this.iterable = iterable
		this.index = -1
	}
	hasNext(): boolean {
		return this.iterable.collection.length > this.index
	}

	next(): [string, number] {
		if (!this.hasNext()) {
			throw Error("can not iterate more")
		}
		this.index += 1
		return [
			this.iterable.collection[this.index].first,
			this.iterable.collection[this.index].second,
		]
	}
}

export class Item {
	first: string
	second: number
	constructor(first: string, second: number) {
		this.first = first
		this.second = second
	}
}

export class ConcreteIterable implements Iterable<[string, number]> {
	collection: Item[]
	constructor(item?: Item) {
		this.collection = []
		item && this.collection.push(item)
	}
	add(item: Item): ConcreteIterable {
		this.collection.push(item)
		return this
	}
	getIterator(): Iterator<[string, number]> {
		return new ConcreteIterator(this)
	}
}
