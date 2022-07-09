package decorator

import (
	"fmt"
	"strings"
)

type LoggerDecorator struct {
	service ServiceInterface
	ServiceInterface
}

func NewLoggerDecorator(service ServiceInterface) LoggerDecorator {
	return LoggerDecorator{service: service}
}

func (l LoggerDecorator) Run(value string) string {
	l.Log(value)
	return l.service.Run(value)
}

func (l *LoggerDecorator) Log(value string) {
	fmt.Println(strings.Join([]string{"Logging: ", value}, ""))
}
