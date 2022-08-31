package commandTest

import (
	"design_patterns_training/patterns/behavioral/command"
	"testing"
)

func TestShouldCallMethodWhenCommandExecutes(t *testing.T) {
	wasCalled := false
	testCh := make(chan string)
	testValue := "test"
	testCommand := command.NewServiceCommand(func(s string, c chan<- string) {
		wasCalled = true
		c <- s
	})
	go testCommand.SetArg(testValue, testCh).Run()
	obtained := <-testCh
	if !wasCalled {
		t.Fatal("Func was not called")
	}
	if obtained != testValue {
		t.Fatalf("%v != %v\n", obtained, testValue)
	}
}
