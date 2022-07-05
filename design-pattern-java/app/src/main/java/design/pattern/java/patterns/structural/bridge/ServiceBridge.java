package design.pattern.java.patterns.structural.bridge;

public class ServiceBridge {
    private final SomeLibrary someLibrary;
    public ServiceBridge(SomeLibrary someLibrary) {
        this.someLibrary = someLibrary;
    }
    public String concreteFeature() {
        return someLibrary.writeString()
            .concat(someLibrary.writeOtherString())
            .concat(someLibrary.integerGenerator().toString());
    }
}
