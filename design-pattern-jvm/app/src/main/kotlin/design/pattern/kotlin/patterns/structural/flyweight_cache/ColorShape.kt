package design.pattern.kotlin.patterns.structural.flyweight_cache

open class ColorShape( val color: String,  val shape: String) {
    open fun move(context: Particle, x: Number, y: Number): Particle {
        return context.setX(x).setY(y)
    }
}