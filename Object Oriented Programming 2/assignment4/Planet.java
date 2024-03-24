package assignment4;

import java.util.ArrayList;
import java.util.List;

class Planet {

  private static final double MIN_RADIUS = 6371;
  private static final double MAX_RADIUS = 69911;
  private static final double MIN_ORBITAL_RADIUS = 149600000;
  private static final double MAX_ORBITAL_RADIUS = 1430000000;

  private String name;
  private double radius;
  private double orbitalRadius;
  private List<Moon> moons;

  public Planet(String name, double radius, double orbitalRadius) {
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
    this.moons = new ArrayList<>();
  }

  public static Planet createPlanet(String name, double radius, double orbitalRadius) {
    return new Planet(name, radius, orbitalRadius);
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

  public List<Moon> getMoons() {
    return moons;
  }

  public void addMoon(Moon moon) {
    moons.add(moon);
  }

  public void deleteMoon(String moonName) {
    moons.removeIf(moon -> moon.getName().equals(moonName));
  }

  protected final void finalize() {
  }
  
}