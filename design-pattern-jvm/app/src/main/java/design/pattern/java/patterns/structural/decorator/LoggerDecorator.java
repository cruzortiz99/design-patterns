package design.pattern.java.patterns.structural.decorator;

public class LoggerDecorator implements ServiceInterface {
    private final ServiceInterface service;

    public LoggerDecorator(ServiceInterface service) {
        this.service = service;
    }

    @Override
    public String run(String value) {
        this.log(value);
        return service.run(value);
    }

    protected void log(String value) {
        System.out.println("Logging: ".concat(value));
    }

}
