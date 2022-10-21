package design.pattern.java.patterns.behavioral.iterator;

public class FibonacciProducer implements Producer<Integer> {
  private Integer index;
  private Integer current;
  private Integer prev;

  public FibonacciProducer() {
    this.index = 0;
    this.current = 1;
    this.prev = 0;
  }

  public static Producer<Integer> create() {
    return new FibonacciProducer();
  }

  @Override
  public Boolean hasNext() {
    return this.index < 10;
  }

  @Override
  public Integer next() {
    if (!this.hasNext()) {
      throw new IndexOutOfBoundsException();
    }
    this.current += this.prev;
    this.prev = this.current - this.prev;
    this.index += 1;
    return this.current;
  }
}
