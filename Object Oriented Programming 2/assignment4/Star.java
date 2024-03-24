package assignment4;

import java.util.ArrayList;
import java.util.List;

class Star {

  private static final double MIN_RADIUS = 16700;
  private static final double MAX_RADIUS = 696340;

  private String name;
  private double radius;
  private double orbitalRadius;
  private List<Planet> planets;

  public Star(String name, double radius) {
    if (radius < MIN_RADIUS || radius > MAX_RADIUS) {
      throw new IllegalArgumentException("Radius must be between " + MIN_RADIUS + " and " + MAX_RADIUS);
    }
    this.name = name;
    this.radius = radius;
    this.planets = new ArrayList<>();
  }

  public static Star createStar(String name, double radius) {
    return new Star(name, radius);
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

  public List<Planet> getPlanets() {
    return planets;
  }

  public void addPlanet(Planet planet) {
    planets.add(planet);
  }

  public void deletePlanet(Planet planet) {
    planets.remove(planet);
  }

  public void deletePlanet(String planetName) {
    planets.removeIf(planet -> planet.getName().equals(planetName));
  }

  public Planet getPlanetByName(String planetName) {
    for (Planet planet : planets) {
      if (planet.getName().equals(planetName)) {
        return planet;
      }
    }
    return null; // Return null if planet is not found
  }

  protected final void finalize() {
  }
  
}