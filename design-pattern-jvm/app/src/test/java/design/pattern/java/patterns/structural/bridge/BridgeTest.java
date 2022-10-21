package design.pattern.java.patterns.structural.bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    class SomeLibraryMock extends SomeLibrary {
        @Override
        public String writeString() {
            return "writeString";
        }
        @Override
        public String writeOtherString() {
            return "writeOtherString";
        }
        @Override
        public Integer integerGenerator() {
            return 5;
        }
    }
    @Test
    public void shouldCallLibraryMethodsWhenBridgeFeatureIsCalled() {
        SomeLibrary someLibraryMock = new SomeLibraryMock();
        ServiceBridge bridge = new ServiceBridge(someLibraryMock);
        String result = bridge.concreteFeature();
        Assertions.assertTrue(
            result.contains(someLibraryMock.writeString()));
        Assertions.assertTrue(
            result.contains(someLibraryMock.writeOtherString()));
        Assertions.assertTrue(
            result.contains(someLibraryMock.integerGenerator().toString()));
    }
}
