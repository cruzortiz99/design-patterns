package design.pattern.kotlin.patterns.behavioral.observer

class NewsPaperSubscriptions(val observable: NewsPaper, val observer: NewsPaperReader) {
  fun unsubscribe() {
    this.observable.readers.removeIf { it.equals(this.observer) }
  }
}
