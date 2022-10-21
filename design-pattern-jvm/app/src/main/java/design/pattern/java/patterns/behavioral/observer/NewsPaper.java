package design.pattern.java.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper {
  List<NewsPaperReader> readers;

  public NewsPaper() {
    this.readers = new ArrayList<>();
  }

  public NewsPaperSubscription subscribe(NewsPaperReader reader) {
    this.readers.add(reader);
    return new NewsPaperSubscription(this, reader);
  }

  public void notify(Notice news) {
    this.readers.forEach(reader -> reader.apply(news));
  }
}