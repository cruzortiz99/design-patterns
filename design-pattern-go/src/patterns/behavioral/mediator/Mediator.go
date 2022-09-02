package mediator

type Mediator interface {
	Notify(airship Airship, event string) string
}
