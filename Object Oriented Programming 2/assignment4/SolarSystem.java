package assignment4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class SolarSystem {
  private String name;
  private Star star;

  public SolarSystem(String name) {
    this.name = name;
    this.star = null;
  }

  public SolarSystem(String name, Star star) {
    this.name = name;
    this.star = star;
  }

  public Star getStar() {
    return star;
  }

  public void setStar(Star star) {
    this.star = star;
  }

  // Method to list details of the solar system
  public void listSolarSystems() {
    System.out.println("Solar System: " + name);
    if (star != null) {
      System.out.println(star.getName() + ":" + star.getRadius());
      List<Planet> planets = star.getPlanets();
      if (!planets.isEmpty()) {
        double totalOrbitalRadius = 0;
        for (Planet planet : planets) {
          System.out.println("-" + planet.getName() + ":" + planet.getRadius() + ":" + planet.getOrbitalRadius());
          totalOrbitalRadius += planet.getOrbitalRadius();
          for (Moon moon : planet.getMoons()) {
            System.out.println("--" + moon.getName() + ":" + moon.getRadius() + ":" + moon.getOrbitalRadius());
          }
        }
        double averageOrbitalRadius = totalOrbitalRadius / planets.size();
        System.out.println("\tAverage Orbital Radius of Planets: " + averageOrbitalRadius);
      }
    }
  }

  // Method to get a list of planets ordered by size
  public List<Planet> getOrderedListBySize() {
    List<Planet> orderedPlanets = new ArrayList<>(star.getPlanets());
    orderedPlanets.sort(Comparator.comparingDouble(Planet::getRadius));
    return orderedPlanets;
  }

  // Method to get a list of planets ordered by orbital radius
  public List<Planet> getOrderedListByOrbitalRadius() {
    List<Planet> orderedPlanets = new ArrayList<>(star.getPlanets());
    orderedPlanets.sort(Comparator.comparingDouble(Planet::getOrbitalRadius));
    return orderedPlanets;
  }

  // Method to save the current state of the solar system to a file
  public void saveToFile(String filename) {
    try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(
        new FileOutputStream(filename), StandardCharsets.UTF_8))) {
      writer.println(star.getName() + ":" + star.getRadius());
      for (Planet planet : star.getPlanets()) {
        writer.println("-" + planet.getName() + ":" + planet.getRadius() + ":" 
            + planet.getOrbitalRadius());
        for (Moon moon : planet.getMoons()) {
          writer.println("--" + moon.getName() + ":" + moon.getRadius());
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  // Method to load a saved state of the solar system from a file
  public void loadFromFile(String filename) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
        new FileInputStream(filename + ".data"), StandardCharsets.UTF_8))) {
      String line;
      Planet lastPlanet = null;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(":");
        if (parts[0].startsWith("-")) { // Planet
          if (parts.length < 3) {
            System.out.println("Invalid line for planet: " + line);
            continue;
          }
          String planetName = parts[0].substring(1);
          double planetRadius = Double.parseDouble(parts[1]);
          double orbitalRadius = Double.parseDouble(parts[2]);
          Planet planet = Planet.createPlanet(planetName, planetRadius, orbitalRadius);
          if (star != null) {
            star.addPlanet(planet);
            lastPlanet = planet;
          } else {
            System.out.println("No star available. Cannot add planet.");
          }
        } else if (parts[0].startsWith("--")) { // Moon
          if (parts.length < 3) {
            System.out.println("Invalid line for moon: " + line);
            continue;
          }
          String moonName = parts[0].substring(2);
          double moonRadius = Double.parseDouble(parts[1]);
          double moonOrbitRadius = Double.parseDouble(parts[2]);
          Moon moon = Moon.createMoon(moonName, moonRadius, moonOrbitRadius);
          if (lastPlanet != null) {
            lastPlanet.addMoon(moon);
          } else {
            System.out.println("Moon " + moonName 
                + " is defined before its parent planet. Skipping.");
          }
        } else { // Star
          if (parts.length < 2) {
            System.out.println("Invalid line for star: " + line);
            continue;
          }
          String starName = parts[0];
          double starRadius = Double.parseDouble(parts[1]);
          star = Star.createStar(starName, starRadius);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Method to delete the star of the solar system
  public void deleteStar() {
    if (star != null) {
      System.out.println("Star " + star.getName() + " has been deleted.");
      star = null;
    } else {
      System.out.println("No star to delete.");
    }
  }

  public String getName() {
    return this.name;
  }

  protected final void finalize() {
  }
  
}