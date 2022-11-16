package templatemehtod

type DataReaderTemplate[T any] struct {
	dataProducer func() []T
}

func NewDataReaderTemplate[T any](producer func() []T) *DataReaderTemplate[T] {
	return &DataReaderTemplate[T]{dataProducer: producer}
}

func (dr *DataReaderTemplate[T]) Get() []T {
	return dr.dataProducer()
}
func Map[T any, NT any](dr *DataReaderTemplate[T], mapper func(T) NT) DataReaderTemplate[NT] {
	return DataReaderTemplate[NT]{
		dataProducer: func() []NT {
			var newList = []NT{}
			for _, value := range dr.dataProducer() {
				newList = append(newList, mapper(value))
			}
			return newList
		},
	}
}
func Filter[T any](dr *DataReaderTemplate[T], predicate func(T) bool) DataReaderTemplate[T] {
	return DataReaderTemplate[T]{
		dataProducer: func() []T {
			var newList = []T{}
			for _, value := range dr.dataProducer() {
				if predicate(value) {
					newList = append(newList, value)
				}
			}
			return newList
		},
	}
}
func Reduce[T any, NT any](dr *DataReaderTemplate[T], reducer func(NT, T) NT, initial NT) DataReaderTemplate[NT] {
	return DataReaderTemplate[NT]{
		dataProducer: func() []NT {
			var acc = initial
			for _, value := range dr.dataProducer() {
				acc = reducer(acc, value)
			}
			return []NT{acc}
		},
	}
}
