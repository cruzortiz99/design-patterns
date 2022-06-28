package design.pattern.java.patterns.creational.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuilderTest {
  @Test
  public void itShouldCreateACarWithTheCorrectValuesWhenBuilderBuildIsCalled() {
    Integer doorsExpected = 2;
    String motorExpected = "6V";
    Float ltsExpected = 1.6f;
    Boolean acExpected = true;
    Boolean electronicsExpected = true;
    Car car = CarBuilder.create().setDoors(doorsExpected)
    .setMotor(motorExpected).setLts(ltsExpected).setAc(acExpected)
    .setElectronic(electronicsExpected).build();
    Assertions.assertEquals(doorsExpected, car.getDoors());
    Assertions.assertEquals(motorExpected, car.getMotor());
    Assertions.assertEquals(ltsExpected, car.getLts());
    Assertions.assertEquals(acExpected, car.getAc());
    Assertions.assertEquals(electronicsExpected, car.getElectronic());
  }
}
