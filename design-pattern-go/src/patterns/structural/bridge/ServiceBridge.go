package bridge

import (
	"strconv"
	"strings"
)

type ServiceBridge struct {
	someLibrary SomeLibraryInterface
}

func New(someLibrary SomeLibraryInterface) *ServiceBridge {
	return &ServiceBridge{
		someLibrary: someLibrary,
	}
}

func (b *ServiceBridge) ConcreteFeature() string {
	return strings.Join([]string{
		b.someLibrary.WriteString(),
		b.someLibrary.WriteOtherString(),
		strconv.Itoa(
			b.someLibrary.IntegerGenerator(),
		),
	}, "")
}
