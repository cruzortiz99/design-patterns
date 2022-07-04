package design.pattern.java.patterns.structural.adapter;

import java.util.function.Function;

public class ServicePrintString implements Function<String, String> {

    @Override
    public String apply(String t) {
        return "From Service received: ".concat(t);
    }
    
}
