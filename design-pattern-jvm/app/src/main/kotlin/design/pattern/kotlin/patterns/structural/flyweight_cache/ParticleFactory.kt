package design.pattern.kotlin.patterns.structural.flyweight_cache


class ParticleFactory private constructor(initialState: ColorShape?) {
    private val cache: MutableList<ColorShape> = mutableListOf()
    init {
        if (initialState != null) {
            cache.add(initialState)
        }
    }
    companion object {
        private var instance: ParticleFactory? = null
        fun create(initialState: ColorShape?): ParticleFactory? {
            if (instance == null) {
                instance = ParticleFactory(initialState)
            }
            return instance
        }
    }

    fun getCache(colorShape: ColorShape): ColorShape {
        val cachedState = cache.stream()
            .filter { savedColorShape: ColorShape -> savedColorShape.color === colorShape.color && savedColorShape.shape === colorShape.shape }
            .reduce { acc: ColorShape?, current: ColorShape? -> acc ?: current }
        if (cachedState.isEmpty) {
            cache.add(colorShape)
            return colorShape
        }
        return cachedState.get()
    }
}