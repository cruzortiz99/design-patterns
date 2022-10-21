package observer

import (
	"design_patterns_training/patterns/behavioral/observer"
	"testing"
)

func TestShouldNotifyEveryReaderAboutAnyNewsWhenNotifyIsCalled(t *testing.T) {
	var wasReader1Called = false
	var wasReader2Called = false
	var ob = observer.NewNewsPaper()
	var reader1 observer.NewsPaperReader = func(n observer.Notice) {
		wasReader1Called = true
	}
	var reader2 observer.NewsPaperReader = func(n observer.Notice) {
		wasReader2Called = true
	}
	ob.Subscribe(&reader1)
	ob.Subscribe(&reader2)
	ob.Notify(observer.NewNotice("test"))

	if !wasReader1Called || !wasReader2Called {
		t.Fatalf("[reader1 called: %v, reader2 called: %v]", wasReader1Called, wasReader2Called)
	}
}
func TestShouldUnsubscribeReaderDoNotReceiveNewsWhenReadeWasUnsubscribe(t *testing.T) {
	var wasReader1Called = false
	var wasReader2Called = false
	var ob = observer.NewNewsPaper()
	var reader1 observer.NewsPaperReader = func(n observer.Notice) {
		wasReader1Called = true
	}
	var reader2 observer.NewsPaperReader = func(n observer.Notice) {
		wasReader2Called = true
	}
	ob.Subscribe(&reader1)
	ob.Subscribe(&reader2).Unsubscribe()

	ob.Notify(observer.NewNotice("test"))

	if !wasReader1Called || wasReader2Called {
		t.Fatalf(
			"[reader1 called: %v, reader2 not called: %v]",
			wasReader1Called,
			!wasReader2Called)
	}
}
