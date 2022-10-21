package design.pattern.java.patterns.structural.bridge;

public class SomeLibrary {
    public SomeLibrary() {}
    public String writeString() {
        return "String wrote";
    }
    public Integer integerGenerator() {
        return Double.valueOf(Math.random() * 100).intValue();
    }
    public String writeOtherString() {
        return "Other string wrote";
    }
}
