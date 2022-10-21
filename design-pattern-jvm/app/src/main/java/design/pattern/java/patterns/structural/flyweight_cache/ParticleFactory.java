package design.pattern.java.patterns.structural.flyweight_cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParticleFactory {
  private static ParticleFactory instance;
  private List<ColorShape> cache;

  private ParticleFactory(ColorShape initialState) {
    this.cache = new ArrayList<>();
    if (initialState != null) {
      this.cache.add(initialState);
    }
  }

  public static ParticleFactory create(ColorShape initialState) {
    if (ParticleFactory.instance == null) {
      ParticleFactory.instance = new ParticleFactory(initialState);
    }
    return ParticleFactory.instance;
  }

  public ColorShape getCache(ColorShape colorShape) {
    Optional<ColorShape> cachedState = this.cache.stream()
        .filter(
            savedColorShape -> savedColorShape.color == colorShape.color && savedColorShape.shape == colorShape.shape)
        .reduce((acc, current) -> acc != null ? acc : current);
    if (cachedState.isEmpty()) {
      this.cache.add(colorShape);
      return colorShape;
    }
    return cachedState.get();
  }
}
