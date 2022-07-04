package adapter

import "strings"

type ServicePrintString struct{}

func (s *ServicePrintString) Apply(input string) string {
	return strings.Join([]string{
		"From Service received: ", input,
	}, "")
}
