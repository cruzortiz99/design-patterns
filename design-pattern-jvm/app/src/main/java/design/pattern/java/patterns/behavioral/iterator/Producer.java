package design.pattern.java.patterns.behavioral.iterator;

public interface Producer<T> {
  Boolean hasNext();

  T next();
}
