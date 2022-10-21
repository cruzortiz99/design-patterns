package design.pattern.kotlin.patterns.behavioral.observer

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ObserverTestKt {
  @Test
  fun shouldNotifyEveryReaderAboutAnyNewsWhenNotifyIsCalled() {
    var wasReader1Called = false
    var wasReader2Called = false
    val newsPaper = NewsPaper()

    newsPaper.subscribe { wasReader1Called = true }
    newsPaper.subscribe { wasReader2Called = true }

    newsPaper.notify(Notice("test"))
    Assertions.assertTrue(wasReader1Called)
    Assertions.assertTrue(wasReader2Called)
  }

  @Test
  fun shouldUnsubscribeReaderDoNotReceiveNewsWhenReadeWasUnsubscribe() {
    var wasReader1Called = false
    var wasReader2Called = false
    val newsPaper = NewsPaper()

    newsPaper.subscribe { wasReader1Called = true }
    newsPaper.subscribe { wasReader2Called = true }.unsubscribe()

    newsPaper.notify(Notice("test"))
    Assertions.assertTrue(wasReader1Called)
    Assertions.assertFalse(wasReader2Called)
  }
}
