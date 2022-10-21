package design.pattern.java.patterns.behavioral.observer;

class NewsPaperSubscription {
  private NewsPaper observable;
  private NewsPaperReader observer;

  NewsPaperSubscription(NewsPaper observable, NewsPaperReader observer) {
    this.observable = observable;
    this.observer = observer;
  }

  void unsubscribe() {
    this.observable.readers.removeIf((reader) -> reader.equals(this.observer));
  }
}
