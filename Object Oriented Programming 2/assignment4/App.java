package assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The main method of the application.
 *
 * @param args The command line arguments.
 */
public class App {
  /**
   * The main method of the application.
   *
   * @param args The command line arguments.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<SolarSystem> solarSystems = new ArrayList<>();

    while (true) {
      System.out.println("Please choose an option from the following menu:");
      System.out.println("1 - Create a new solar system");
      System.out.println("2 - Add a star to the solar system");
      System.out.println("3 - Add a planet to a star");
      System.out.println("4 - Add a moon to a planet");
      System.out.println("5 - List all members in the solar systems");
      System.out.println("6 - Save the current state of the solar system to a file");
      System.out.println("7 - Load a saved state of the solar system from a file");
      System.out.println("8 - Delete a star, planet, or moon from the solar system");
      System.out.println("0 - Exit the program");
      System.out.println("Enter your choice:");
      int option = scanner.nextInt();
      scanner.nextLine(); // consume newline


      if (option == 1) {
        // Create a new solar system
        System.out.println("Enter the name of the new Solar System:");
        String newSolarSystemName = scanner.nextLine();
        SolarSystem newSolarSystem = new SolarSystem(newSolarSystemName);
        solarSystems.add(newSolarSystem);

      // Modify existing solar systems
      } else if (option > 1 && option <= 7) {
        System.out.println("Enter the name of the Solar System you want to modify:");
        System.out.println("Existing Solar Systems:");
        for (SolarSystem sys : solarSystems) {
          System.out.println(sys.getName());
        }
        String modifySolarSystemName = scanner.nextLine();
        SolarSystem solarSystem = solarSystems.stream()
            .filter(s -> s.getName().equals(modifySolarSystemName))
            .findFirst()
            .orElse(null);
        if (solarSystem == null) {
          System.out.println("No such Solar System exists.");
          continue;


        } else if (option == 2) {
          System.out.println("Enter the name of the Star:");
          String starName = scanner.nextLine();
          System.out.println("Enter the radius of the Star:");
          try {
            double starRadius = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            Star star = new Star(starName, starRadius);
            solarSystem.setStar(star);
          } catch (IllegalArgumentException e) {
            System.out.println("Invalid radius or orbital radius. " + e.getMessage());
            continue;
          }


        } else if (option == 3) {
          System.out.println("Enter the name of the Planet:");
          final String planetName = scanner.nextLine();
          System.out.println("Enter the radius of the Planet:");
          try {
            double planetRadius = scanner.nextDouble();
            System.out.println("Enter the orbital radius of the Planet:");
            double planetOrbitalRadius = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            Planet planet = new Planet(planetName, planetRadius, planetOrbitalRadius);
            if (solarSystem.getStar() != null) {
              solarSystem.getStar().addPlanet(planet);
            } else {
              System.out.println("No star available. Cannot add planet.");
            }
          } catch (IllegalArgumentException e) {
            System.out.println("invalid radius or orbital radius. " + e.getMessage());
            continue;
          }
        } else if (option == 4) {
          System.out.println("Enter the name of the planet of the moon:");
          final String planetNameForMoon = scanner.nextLine();
          System.out.println("Enter the name of the Moon:");
          final String moonName = scanner.nextLine();
          System.out.println("Enter the radius of the Moon:");
          try {
            double moonRadius = scanner.nextDouble();
            System.out.println("Enter the orbital radius of the Moon:");
            double moonOrbitRadius = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            Moon moon = new Moon(moonName, moonRadius, moonOrbitRadius);
            if (solarSystem.getStar() != null) {
              for (Planet planet : solarSystem.getStar().getPlanets()) {
                if (planet.getName().equals(planetNameForMoon)) {
                  planet.addMoon(moon);
                  break;
                }
              }
            } else {
              System.out.println("No star available. Cannot add moon.");
            }
          } catch (IllegalArgumentException e) {
            System.out.println("Invalid radius or orbital radius. " + e.getMessage());
            continue;
          }
        } else if (option == 5) {
          System.out.println("List of all created solar systems:");
          for (SolarSystem solarSystem1 : solarSystems) {
            solarSystem1.listSolarSystems();
          }

        } else if (option == 6) {
          System.out.println("Enter filename to save:");
          String filename = scanner.nextLine();
          solarSystem.saveToFile(filename);

        } else if (option == 7) {
          System.out.println("Enter filename to load:");
          String filename = scanner.nextLine();
          solarSystem.loadFromFile(filename);

        } else if (option == 8) {
          System.out.println("Enter 1 to delete a star, 2 to delete a planet, 3 to delete a moon:");
          int deleteOption = scanner.nextInt();
          scanner.nextLine(); // consume newline
        
          if (deleteOption == 1) {
            solarSystem.deleteStar();
          } else if (deleteOption == 2) {
            System.out.println("Enter the name of the planet to delete:");
            String planetName = scanner.nextLine();
            if (solarSystem.getStar() != null) {
              solarSystem.getStar().deletePlanet(planetName);
            }
          } else if (deleteOption == 3) {
            System.out.println("Enter the name of the planet of the moon:");
            final String planetNameForMoonDeletion = scanner.nextLine();
            System.out.println("Enter the name of the moon to delete:");
            String moonName = scanner.nextLine();
            if (solarSystem.getStar() != null) {
              for (Planet planet : solarSystem.getStar().getPlanets()) {
                if (planet.getName().equals(planetNameForMoonDeletion)) {
                  planet.deleteMoon(moonName);
                  break;
                }
              }
            }
          }
        }
      } else if (option == 0) {
        System.out.println("Goodbye!");
        break;
      }
    }
    scanner.close();
  }
}