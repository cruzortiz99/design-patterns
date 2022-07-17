package proxy

import "strings"

type Service interface {
	AddPrefix(word string) string
}

type AddCustomPrefixService struct {
	prefix string
	Service
}

func (s *AddCustomPrefixService) AddPrefix(word string) string {
	return strings.Join([]string{s.prefix, word}, "")
}
