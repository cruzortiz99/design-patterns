package design.pattern.java.patterns.structural.proxy;

public class AddCustomPrefix implements Service {
  private final String prefix;

  public AddCustomPrefix(final String prefix) {
    this.prefix = prefix;
  }

  @Override
  public String addPrefix(String word) {
    return prefix.concat(word);
  }
}
