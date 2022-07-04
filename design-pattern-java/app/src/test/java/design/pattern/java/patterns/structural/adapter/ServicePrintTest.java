package design.pattern.java.patterns.structural.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServicePrintTest {
    @Test
    public void itShouldReturnStringWithExtendedMessageWhenServiceIsCalled() {
        String input = "some test";
        ServicePrintString service = new ServicePrintString();
        String result = service.apply(input);
        Assertions.assertNotEquals(input, result);
        Assertions.assertTrue(result.endsWith(input));
    }
    @Test
    public void itShouldReturnStringWithMessageWhenAdapterIsCalled() {
        Integer input = 345;
        AdapterIntToString serviceAdapted = new AdapterIntToString(
            new ServicePrintString());
        String result = serviceAdapted.apply(input);
        Assertions.assertNotEquals(String.valueOf(input), result);
        Assertions.assertTrue(result.endsWith(String.valueOf(input)));
    }
}
