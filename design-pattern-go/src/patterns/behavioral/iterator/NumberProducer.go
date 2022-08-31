package iterator

import "fmt"

type FibonacciProducer struct {
	index   int
	current int
	prev    int
}

func NewFibonacciProducer() Producer[int] {
	return &FibonacciProducer{index: 0, current: 1, prev: 0}
}

func (p *FibonacciProducer) HasNext() bool {
	return p.index < 10
}

func (p *FibonacciProducer) Next() (int, error) {
	if !p.HasNext() {
		return 0, fmt.Errorf("Index out of bound")
	}
	if p.current == 0 {
		p.current = 1
		p.prev = 0
	}
	p.current += p.prev
	p.prev = p.current - p.prev
	p.index++
	return p.current, nil
}
