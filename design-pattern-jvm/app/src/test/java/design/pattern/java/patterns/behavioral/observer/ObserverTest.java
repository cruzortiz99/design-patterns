package design.pattern.java.patterns.behavioral.observer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObserverTest {
  class BooleanWrapper {
    Boolean value;

    BooleanWrapper(Boolean value) {
      this.value = value;
    }
  }

  @Test
  void shouldNotifyEveryReaderAboutAnyNewsWhenNotifyIsCalled() {
    BooleanWrapper wasReader1Called = new BooleanWrapper(false);
    BooleanWrapper wasReader2Called = new BooleanWrapper(false);
    NewsPaper newsPaper = new NewsPaper();

    newsPaper.subscribe((news) -> {
      wasReader1Called.value = true;
    });
    newsPaper.subscribe((news) -> {
      wasReader2Called.value = true;
    });

    newsPaper.notify(new Notice("test"));
    Assertions.assertTrue(wasReader1Called.value);
    Assertions.assertTrue(wasReader2Called.value);
  }

  @Test
  void shouldUnsubscribeReaderDoNotReceiveNewsWhenReadeWasUnsubscribe() {
    BooleanWrapper wasReader1Called = new BooleanWrapper(false);
    BooleanWrapper wasReader2Called = new BooleanWrapper(false);
    NewsPaper newsPaper = new NewsPaper();

    newsPaper.subscribe((news) -> {
      wasReader1Called.value = true;
    });
    newsPaper.subscribe((news) -> {
      wasReader2Called.value = true;
    }).unsubscribe();

    newsPaper.notify(new Notice("test"));
    Assertions.assertTrue(wasReader1Called.value);
    Assertions.assertFalse(wasReader2Called.value);
  }
}
