package main

import (
	"fmt"
	"os"
)

func main() {
	args := os.Args[1:]
	printArgs(args...)
}

func printArgs(args ...string) {
	fmt.Println(args)
}
