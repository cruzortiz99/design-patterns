package design.pattern.kotlin.patterns.behavioral.observer

class NewsPaper() {
  var readers: MutableList<NewsPaperReader> = mutableListOf()

  fun subscribe(reader: NewsPaperReader): NewsPaperSubscriptions {
    this.readers.add(reader)
    return NewsPaperSubscriptions(this, reader)
  }

  fun notify(news: Notice) {
    this.readers.forEach { it.invoke(news) }
  }
}
