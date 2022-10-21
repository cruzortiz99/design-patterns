package observer

type newsPaperSubscription struct {
	observable *NewsPaper
	observer   *NewsPaperReader
}

func (n *newsPaperSubscription) Unsubscribe() {
	var newReaders = []*NewsPaperReader{}
	for _, reader := range n.observable.readers {
		if reader != n.observer {
			newReaders = append(newReaders, reader)
		}
	}
	n.observable.readers = newReaders
}
