package main

import (
	"fmt"
	"strings"
	"time"
)

type User struct {
	id        int
	firstName string
	lastName  string
}

func mapUser(mapper func(value User, index int) string, users []User) []string {
	var newSlice []string
	for index, user := range users {
		mapper(user, index)
	}
	return newSlice
}
func sendEmailRequest(username string) {
	fmt.Println("#######################")
	fmt.Printf("Sending email ticket to: %v\n", username)
	fmt.Println("#######################")
	time.Sleep(time.Duration(10) * time.Second)
	fmt.Println("#######################")
	fmt.Printf("Email ticket sent to: %v\n", username)
	fmt.Println("#######################")
}

func main() {
	var conferenceName = "Go Conference"
	const CONFERENCE_TICKETS = 50
	// Alternative sintax for assigment
	soldTickets := 0
	// Arrays have fixed size
	// var bookings [50]string
	// var bookings []map[string]string
	var bookings = make([]User, 0)

	fmt.Printf("Wellcome to %v booking application\n", conferenceName)
	fmt.Printf("We have a total of %v, and %v are availables\n", CONFERENCE_TICKETS,
		CONFERENCE_TICKETS-soldTickets)
	fmt.Println("Get your tickets here to attend")

	// Infinite loop
	// for {
	// For loop given a condition
	for soldTickets < CONFERENCE_TICKETS {
		var iteration = 0
		var firstName string
		var lastName string

		fmt.Print("Insert Name: ")
		fmt.Scan(&firstName)
		fmt.Print("Insert Last Name: ")
		fmt.Scan(&lastName)

		// Array must no index for inserts
		// bookings[0] = firstName+" "+lastName
		var userData = User{
			firstName: firstName,
			lastName:  lastName,
			id:        iteration,
		}
		bookings = append(bookings, userData)
		soldTickets = len(bookings)
		var firtNames = mapUser(func(value User, index int) string {
			var names = strings.Fields(value.firstName)
			return names[0]
		}, bookings)
		fmt.Printf("All the bookings first names: %v\n", firtNames)
		// Sending this execution to a new thread
		go sendEmailRequest(userData.firstName)
		if soldTickets >= CONFERENCE_TICKETS {
			fmt.Println("Our conference is sold out, come back next year")
			break
		}
	}
}
