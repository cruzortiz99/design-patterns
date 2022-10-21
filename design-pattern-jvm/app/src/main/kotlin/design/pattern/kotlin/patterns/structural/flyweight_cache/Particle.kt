package design.pattern.kotlin.patterns.structural.flyweight_cache

class Particle(var x: Number, var y: Number, val colorShape: ColorShape) {
    fun move(x: Number, y: Number): Particle {
        return colorShape.move(this, x, y)
    }

    fun setX(x: Number): Particle {
        this.x = x
        return this
    }

    fun setY(y: Number): Particle {
        this.y = y
        return this
    }
}