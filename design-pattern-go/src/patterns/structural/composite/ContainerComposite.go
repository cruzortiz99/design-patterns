package composite

import (
	"strings"
)

type ContainerComposite struct {
	children []*UIComponent
	UIComponent
}

func NewContainerComponent(component UIComponent) ContainerComposite {
	return ContainerComposite{
		children: []*UIComponent{&component},
	}
}
func (c ContainerComposite) Render() string {
	result := ""
	for _, componentRef := range c.children {
		component := *componentRef
		result = strings.Join([]string{
			component.Render(),
		}, result)
	}
	return result
}
func (c *ContainerComposite) Add(
	component *UIComponent) *ContainerComposite {
	c.children = append(c.children, component)
	return c
}
func (c *ContainerComposite) Remove(component *UIComponent) {
	filteredChildren := []*UIComponent{}
	for _, compRef := range c.children {
		if compRef != component {
			filteredChildren = append(filteredChildren, compRef)
		}
	}
	c.children = filteredChildren
}
