package design.pattern.kotlin.patterns.creational.builder

class CarBuilder private constructor(private val car: Car = Car(
    doors = 2,
    motor = "4L",
    lts = 1.4f,
    ac = false,
    electronic = false
)) {
    fun setDoors(doors: Int?): CarBuilder {
        car.doors = doors
        return this
    }
    fun setMotor(motor: String?): CarBuilder {
        car.motor = motor
        return this
    }
    fun setLts(lts: Float?): CarBuilder {
        car.lts = lts
        return this
    }
    fun setAc(ac: Boolean?): CarBuilder {
        car.ac = ac
        return this
    }
    fun setElectronic(electronic: Boolean?): CarBuilder {
        car.electronic = electronic
        return this
    }
    fun build(): Car {
        return car
    }
    companion object {
        fun create(): CarBuilder {
            return CarBuilder()
        }
    }
}