package iterator

import (
	"design_patterns_training/patterns/behavioral/iterator"
	"testing"
)

func TestShouldProduceFibonacciSequenceWhenNextIsCalled(t *testing.T) {
	var fbProducer = iterator.NewFibonacciProducer()
	var prev = 0
	var current = 1
	for fbProducer.HasNext() {
		var obtained, _ = fbProducer.Next()
		if obtained != prev+current {
			t.Fatalf(
				"Value must match fibonacci, [obtained: %v][expected: %v]\n",
				obtained, current+prev)
		}
		current += prev
		prev = current - prev
	}
}
func TestShouldReturnErrorWhenIndexOutOfBound(t *testing.T) {
	var fbProducer = iterator.NewFibonacciProducer()
	for fbProducer.HasNext() {
		fbProducer.Next()
	}
	var value, err = fbProducer.Next()
	if err == nil || value != 0 {
		t.Fatalf(
			"Must return error(obtained: %T) and value should be 0(obtained: %v)", err,
			value)
	}
}
