package bridge

import "math/rand"

type SomeLibraryInterface interface {
	WriteString() string
	IntegerGenerator() int
	WriteOtherString() string
}
type SomeLibrary struct {
	SomeLibraryInterface
}

func (s SomeLibrary) WriteString() string {
	return "String wrote"
}

func (s SomeLibrary) IntegerGenerator() int {
	return rand.Int()
}

func (s SomeLibrary) WriteOtherString() string {
	return "Other string wrote"
}
