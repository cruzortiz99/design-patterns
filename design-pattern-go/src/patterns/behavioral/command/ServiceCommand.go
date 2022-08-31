package command

import "fmt"

type ServiceCommandBuilder struct {
	value   string
	ch      chan<- string
	service func(string, chan<- string)
}

type ServiceCommand struct {
	command *ServiceCommandBuilder
}

func NewServiceCommand(service func(string, chan<- string)) ServiceCommandBuilder {
	return ServiceCommandBuilder{service: service}
}

func (c *ServiceCommandBuilder) SetArg(value string, ch chan<- string) *ServiceCommand {
	c.value = value
	c.ch = ch
	return &ServiceCommand{command: c}
}

func (r *ServiceCommand) Run() {
	if r.command.ch == nil {
		fmt.Println("Chan must be set")
		return
	}
	r.command.service(r.command.value, r.command.ch)
}
