package design.pattern.java.patterns.structural.adapter;

import java.util.function.Function;


public class AdapterIntToString implements Function<Integer, String>{

    private final Function<String, String> service;

    public AdapterIntToString(Function<String, String> service) {
        this.service = service;
    }

    @Override
    public String apply(Integer input) {
        return this.service.apply(String.valueOf(input));
    }
    
}
