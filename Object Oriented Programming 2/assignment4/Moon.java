package assignment4;

/**
 * Represents the minimum radius of a moon.
 */
public class Moon {
  private static final double MIN_RADIUS = 6;
  private static final double MAX_RADIUS = 2634;
  private static final double MIN_ORBITAL_RADIUS = 9400;
  private static final double MAX_ORBITAL_RADIUS = 1882700;

  private String name;
  private double radius;
  private double orbitalRadius;


  /**
   * Represents a moon with a given name and radius.
   *
   * @param name   the name of the moon
   * @param radius the radius of the moon
   * @throws IllegalArgumentException if the radius is not within the valid range
   */
  public Moon(String name, double radius, double orbitalRadius) {
    if (radius < MIN_RADIUS || radius > MAX_RADIUS) {
      throw new IllegalArgumentException("Radius must be between " + MIN_RADIUS + " and " + MAX_RADIUS);
    }
    if (orbitalRadius < MIN_ORBITAL_RADIUS || orbitalRadius > MAX_ORBITAL_RADIUS) {
      throw new IllegalArgumentException("Orbital radius must be between " 
      + MIN_ORBITAL_RADIUS + " and " + MAX_ORBITAL_RADIUS);
    }
    this.name = name;
    this.radius = radius;
    this.orbitalRadius = orbitalRadius;
  }

  public static Moon createMoon(String name, double radius, double orbitalRadius) {
    return new Moon(name, radius, orbitalRadius);
  }

  public String getName() {
    return name;
  }

  public double getRadius() {
    return radius;
  }

  public double getOrbitalRadius() {
    return orbitalRadius;
  }

  protected final void finalize() {
  }
  
}
