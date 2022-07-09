package decorator

import (
	"design_patterns_training/patterns/structural/decorator"
	"testing"
)

type DecoratorMock struct {
	wasCalled bool
	decorator.LoggerDecorator
}

func NewDecoratorMock(service decorator.ServiceInterface) DecoratorMock {
	return DecoratorMock{
		wasCalled:       false,
		LoggerDecorator: decorator.NewLoggerDecorator(service),
	}
}

func (m *DecoratorMock) Run(value string) string {
	m.Log(value)
	return m.LoggerDecorator.Run(value)
}

func (m *DecoratorMock) Log(value string) {
	m.wasCalled = true
	m.LoggerDecorator.Log(value)
}
func (m *DecoratorMock) HasBeenCalled() bool {
	return m.wasCalled
}

type ServiceMock struct {
	wasCalled bool
	decorator.ServicePrintString
}

func NewServiceMock() ServiceMock {
	return ServiceMock{wasCalled: false}
}
func (m *ServiceMock) Run(value string) string {
	m.wasCalled = true
	return m.ServicePrintString.Run(value)
}
func (m *ServiceMock) HasBeenCalled() bool {
	return m.wasCalled
}

func TestShouldCallTheExtraMethod(t *testing.T) {
	service := decorator.ServicePrintString{}
	mock := NewDecoratorMock(service)
	mock.Run("test")
	if !mock.HasBeenCalled() {
		t.Fatal("Decorator extra method was not called")
	}
}

func TestShouldCallWrappedMethod(t *testing.T) {
	service := NewServiceMock()
	mock := NewDecoratorMock(&service)
	mock.Run("test")
	if !service.HasBeenCalled() {
		t.Fatal("Service was not called")
	}
}
