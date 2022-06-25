package main

import (
	"design_patterns_training/patterns/builder/factory_method"
	"fmt"
	"strings"
	"time"
)

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
	var bookings = make([]factory_method.User, 0)

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
		var userData = factory_method.User{
			FirstName: firstName,
			LastName:  lastName,
			Id:        iteration,
		}
		bookings = append(bookings, userData)
		soldTickets = len(bookings)
		var firtNames = factory_method.MapUser(func(value factory_method.User, index int) string {
			var names = strings.Fields(value.FirstName)
			return names[0]
		}, bookings)
		fmt.Printf("All the bookings first names: %v\n", firtNames)
		// Sending this execution to a new thread
		go sendEmailRequest(userData.FirstName)
		if soldTickets >= CONFERENCE_TICKETS {
			fmt.Println("Our conference is sold out, come back next year")
			break
		}
	}
}
