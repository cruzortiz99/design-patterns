package design.pattern.java.patterns.behavioral.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class IteratorTest {
  @Test
  public void shouldProduceFibonacciSequenceWhenNextIsCalled() {
    Producer<Integer> fbProducer = new FibonacciProducer();
    Integer current = 1;
    Integer prev = 0;
    while (fbProducer.hasNext()) {
      Integer obtained = fbProducer.next();
      assertEquals(current + prev, obtained);
      current += prev;
      prev = current - prev;
    }
  }

  @Test
  public void shouldThrowExceptionWhenIndexOutOfBound() {
    Producer<Integer> fbProducer = new FibonacciProducer();
    while (fbProducer.hasNext()) {
      fbProducer.next();
    }
    try {
      fbProducer.next();
      fail("Must throw index out of bound exception");
    } catch (IndexOutOfBoundsException e) {
      assertTrue(true);
    } catch (Exception e) {
      fail("Must throw index out of bound exception");
    }
  }
}
