import { Item, ConcreteIterable } from "@patterns/behavioral/iterator"
describe("Behavioral Pattern: Iterator", () => {
	it("Should deliver a tuple of the values of the item", () => {
		const firstItemMock = new Item("t", 1)
		const secondItemMock = new Item("te", 2)
		const thirdItemMock = new Item("tes", 3)
		const fourthItemMock = new Item("test", 4)
		const iterator = new ConcreteIterable()
			.add(firstItemMock)
			.add(secondItemMock)
			.add(thirdItemMock)
			.add(fourthItemMock)
			.getIterator()
		const firstTuple = iterator.next()
		const secondTuple = iterator.next()
		const thirdTuple = iterator.next()
		const fourthTuple = iterator.next()
		expect(firstTuple).toStrictEqual([
			firstItemMock.first,
			firstItemMock.second,
		])
		expect(secondTuple).toStrictEqual([
			secondItemMock.first,
			secondItemMock.second,
		])
		expect(thirdTuple).toStrictEqual([
			thirdItemMock.first,
			thirdItemMock.second,
		])
		expect(fourthTuple).toStrictEqual([
			fourthItemMock.first,
			fourthItemMock.second,
		])
	})
	it("Should throw error when cant get more items", () => {
		const iterator = new ConcreteIterable().getIterator()
		expect(() => iterator.next()).toThrow()
	})
})
