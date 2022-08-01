package chainresponsibility

type Container struct {
	ComponentWithHandler
	Leaf
}

func NewContainer(handler func()) Container {
	return Container{
		Leaf: NewLeaf(handler),
	}
}

func (c *Container) Add(leaf *Leaf) *Container {
	leaf.SetContainer(c)
	return c
}
func (c *Container) Handle() {
	c.Leaf.Handle()
}
