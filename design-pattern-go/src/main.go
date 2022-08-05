package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"os"
)

func main() {
	args := os.Args[1:]
	printArgs(args...)
	// res, err := httpRequest()
	// if err != nil {
	// 	fmt.Printf("%v", err)
	// }
	// fmt.Printf("2- %T\n", res)
}

func printArgs(args ...string) {
	fmt.Println(args)
}
func httpRequest() (interface{}, error) {
	res, err := http.Get("https://api.publicapis.org/entries")
	if err != nil {
		return nil, err
	}
	defer res.Body.Close()
	body, err := ioutil.ReadAll(res.Body)
	if err != nil {
		return nil, err
	}
	fmt.Printf("1- %T\n", string(body))
	return string(body), nil
}
