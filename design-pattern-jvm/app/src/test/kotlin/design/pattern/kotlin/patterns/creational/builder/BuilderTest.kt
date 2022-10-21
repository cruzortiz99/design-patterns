package design.pattern.kotlin.patterns.creational.builder

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BuilderTestKt {
    @Test
    fun itShouldCreateACarWithTheCorrectValuesWhenBuilderBuildIsCalled() {
        val doorsExpected = 2
        val motorExpected = "6V"
        val ltsExpected = 1.6f
        val acExpected = true
        val electronicsExpected = true
        val (doors, motor, lts, ac, electronic) =
                CarBuilder.create()
                        .setDoors(doorsExpected)
                        .setMotor(motorExpected)
                        .setLts(ltsExpected)
                        .setAc(acExpected)
                        .setElectronic(electronicsExpected)
                        .build()
        Assertions.assertEquals(doorsExpected, doors)
        Assertions.assertEquals(motorExpected, motor)
        Assertions.assertEquals(ltsExpected, lts)
        Assertions.assertEquals(acExpected, ac)
        Assertions.assertEquals(electronicsExpected, electronic)
    }
}
