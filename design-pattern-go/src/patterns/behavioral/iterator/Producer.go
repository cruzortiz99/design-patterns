package iterator

type Producer[T any] interface {
	HasNext() bool
	Next() (T, error)
}
