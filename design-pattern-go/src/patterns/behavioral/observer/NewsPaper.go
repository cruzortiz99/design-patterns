package observer

type NewsPaper struct {
	readers []*NewsPaperReader
}

func NewNewsPaper() *NewsPaper {
	return &NewsPaper{readers: []*NewsPaperReader{}}
}

func (n *NewsPaper) Subscribe(reader *NewsPaperReader) *newsPaperSubscription {
	n.readers = append(n.readers, reader)
	return &newsPaperSubscription{observable: n, observer: reader}
}

func (n *NewsPaper) Notify(newNotice Notice) {
	for _, reader := range n.readers {
		(*reader)(newNotice)
	}
}
