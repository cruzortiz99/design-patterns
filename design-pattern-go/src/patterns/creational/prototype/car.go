package prototype

type Car struct {
	Name string
}

func CarNew(name string) *Car {
	return &Car{Name: name}
}

func (c Car) Copy() CarPrototype {
	return Car{
		Name: c.Name,
	}
}
