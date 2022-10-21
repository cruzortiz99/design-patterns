package design.pattern.java.patterns.behavioral.observer;

@FunctionalInterface
public interface NewsPaperReader {
  public void apply(Notice news);
}
