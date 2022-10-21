/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package design.pattern.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        Map<String, String> params = App.makeMapProperties(args);
        System.out.println(params.keySet());
    }

    public static Map<String, String> makeMapProperties(String... args) {
        return Stream.of(args)
                .filter(Objects::nonNull)
                .filter(arg -> arg.startsWith("-P"))
                .filter(arg -> arg.contains("="))
                .reduce(
                        new HashMap<String, String>(),
                        (acc, validArg) -> {
                            acc.put(
                                    validArg.split("=")[0].trim().split("-P")[1],
                                    validArg.split("=")[1].trim()
                            );
                            return acc;
                        },
                        (m, m2) -> {
                            m.putAll(m2);
                            return m;
                        }
                );

    }

    public String getGreeting() {
        return "Hello World!";
    }
}
