package decorator

import (
	"strings"
)

type ServicePrintString struct {
	ServiceInterface
}

func (s ServicePrintString) Run(value string) string {
	return strings.Join([]string{"Print: ", value}, "")
}
