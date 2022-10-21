package observer

type Notice struct {
	description string
}

func NewNotice(description string) Notice {
	return Notice{description: description}
}
