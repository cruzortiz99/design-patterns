package command

import "fmt"

func Service(value string, ch chan<- string) {
	ch <- fmt.Sprintf("Service: [[value, %v]]", value)
}
