package chainresponsibility

type Container struct {
	children []*Leaf
	ComponentWithHandler
	Leaf
}

func NewContainer(handler func()) Container {
	return Container{
		children: []*Leaf{},
		Leaf:     NewLeaf(handler),
	}
}

func (c *Container) Add(leaf *Leaf) *Container {
	leaf.SetContainer(c)
	c.children = append(c.children, leaf)
	return c
}
func (c *Container) Handle() {
	c.Leaf.Handle()
}
