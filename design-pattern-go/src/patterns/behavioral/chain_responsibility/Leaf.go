package chainresponsibility

type Leaf struct {
	handler   func()
	container *Container
	ComponentWithHandler
}

func NewLeaf(handler func()) Leaf {
	return Leaf{handler: handler, container: nil}
}

func (l *Leaf) SetContainer(container *Container) {
	l.container = container
}
func (l *Leaf) Handle() {
	if l.handler != nil {
		l.handler()
	} else if l.container != nil {
		l.container.Handle()
	}
}
