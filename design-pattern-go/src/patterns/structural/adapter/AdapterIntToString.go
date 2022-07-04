package adapter

import (
	"strconv"
)

type AdapterIntToString struct {
	service ServicePrintString
}

func (ad *AdapterIntToString) AddService(
	service ServicePrintString) *AdapterIntToString {
	ad.service = service
	return ad
}
func (ad *AdapterIntToString) Apply(input int) string {
	return ad.service.Apply(strconv.Itoa(input))
}
