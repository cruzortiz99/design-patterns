package proxy

import (
	"design_patterns_training/patterns/structural/proxy"
	"testing"
)

type ServiceMock struct {
	wasCalled bool
	times     int
	service   proxy.Service
	proxy.Service
}

func newServiceMock(service proxy.Service) ServiceMock {
	return ServiceMock{wasCalled: false, times: 0, service: service}
}

func (s *ServiceMock) AddPrefix(word string) string {
	s.wasCalled = true
	s.times++
	service := s.service
	return service.AddPrefix(word)
}
func (s *ServiceMock) HasBeenCalled() bool {
	return s.wasCalled
}
func (s *ServiceMock) HasBeenCalledTimes(expected int) bool {
	return s.wasCalled && s.times == expected
}

func TestShouldCallServiceWhenSameMethodProxyIsCalled(t *testing.T) {
	service := proxy.NewAddCustomPrefixService("")
	mock := newServiceMock(&service)
	proxy := proxy.NewServiceProxy(&mock)
	proxy.AddPrefix("test")
	if !mock.HasBeenCalled() {
		t.Fatal("Service was not called")
	}
}
func TestShouldCallService1WhenSameMethInProxyIsCalledMultipleTimes(
	t *testing.T) {
	service := proxy.NewAddCustomPrefixService("")
	mock := newServiceMock(&service)
	proxy := proxy.NewServiceProxy(&mock)
	proxy.AddPrefix("1")
	proxy.AddPrefix("1")
	proxy.AddPrefix("1")
	if !mock.HasBeenCalledTimes(1) {
		t.Fatal("Service was called more than once")
	}
}

func TestShouldReturnCachedValueWhenSameParamsIsSentThroughTheMeth(
	t *testing.T) {
	service := proxy.NewAddCustomPrefixService("test")
	proxy := proxy.NewServiceProxy(&service)
	firstResult := proxy.AddPrefix("1")
	secondResult := proxy.AddPrefix("1")
	thirdResult := proxy.AddPrefix("1")
	if firstResult == secondResult && secondResult == thirdResult {
		return
	}
	t.Fatal("Results should be the same")
}
