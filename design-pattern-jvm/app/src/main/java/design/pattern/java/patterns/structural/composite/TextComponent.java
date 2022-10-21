package design.pattern.java.patterns.structural.composite;

public class TextComponent implements UIComponent{
    private String message;
    public TextComponent(String message) {
        this.message = message;
    }
    @Override
    public String render() {
        return message;
    }
    public String getMessage() {
        return this.message;
    }
}
