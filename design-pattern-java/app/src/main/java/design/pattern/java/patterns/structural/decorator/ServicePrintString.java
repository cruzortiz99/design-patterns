package design.pattern.java.patterns.structural.decorator;

public class ServicePrintString implements ServiceInterface {

    @Override
    public String run(String value) {
        return "Printing: ".concat(value);
    }
}
