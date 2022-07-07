import {
	ContainerComposite,
	TextComponent,
	UIComponent,
} from "@src/patterns/structural/composite"

describe("Structural Pattern: Composite", () => {
	it("Should call component render when container render", () => {
		const child: UIComponent = {
			render: jest.fn(() => ""),
		}
		new ContainerComposite(child).render()
		expect(child.render).toHaveBeenCalledTimes(1)
	})
  it("Should contain child text msg when render container is called", () => {
    const child = new TextComponent("text msg")
    const ui = new ContainerComposite(child).render()
    expect(ui).toContain(child.getMessage())
  })
})
