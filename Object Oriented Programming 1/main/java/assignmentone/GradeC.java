package assignmentone;

import java.util.List;
import java.util.Scanner;

/**
 * This is the class for the C grade part of the assignment.
 */
public class GradeC {
  /**
   * Solution to the calcutlator task.
   *
   * @param input is the scanner used to read input from the user.
   */
  public void calculator(Scanner input) {
    Calculator calculator = new Calculator();
    System.out.print("\nTask 6: \n");
    // println = input is on the next line, print = same line
    System.out.print("Enter two numbers: ");
    double n1 = input.nextDouble();
    double n2 = input.nextDouble();

    System.out.println("Select a method (add, subtract, multiply, divide): ");
    String operation = input.next();

    double result = 0.0;
    switch (operation) {
      case "add":
        result = calculator.add(n1, n2);
        break;
      case "subtract":
        result = calculator.subtract(n1, n2);
        break;
      case "multiply":
        result = calculator.multiply(n1, n2);
        break;
      case "divide":
        result = calculator.divide(n1, n2);
        
        if (calculator.isDivideByZero()) {
          System.out.println("Division by 0 is not allowed!");
          return;
        }
        break;
      default:
        System.out.println("Invalid operation!");
        return;
    }
    
    // Print the result
    System.out.println("The result is: " + result);
  }

  /**
   * Solution to the genre task.
   */
  public void band() {
    // Creating an instance of the Band class for Two Door Cinema Club
    Band twoDoorCinemaClub = new Band("Two Door Cinema Club", 2007);

    // Adding albums to the band's discography
    twoDoorCinemaClub.addAlbum("Tourist History", 2010);
    twoDoorCinemaClub.addAlbum("Beacon", 2012);
    twoDoorCinemaClub.addAlbum("Gameshow", 2016);
    twoDoorCinemaClub.addAlbum("False Alarm", 2019);
    twoDoorCinemaClub.addAlbum("Keep On Smiling", 2022);

    // Displaying band information
    System.out.print("\nTask 7: \n");
    System.out.println("\nBand Name: " + twoDoorCinemaClub.getName());
    System.out.println("The Band was formed in " + twoDoorCinemaClub.getYear());

    // Retrieving the band's discography
    List<Album> discography = twoDoorCinemaClub.getDiscography();

    // Displaying the band's discography
    System.out.println("\nAlbums of Two Door Cinema Club:");
    for (Album album : discography) {
      System.out.println(album.getTitle() + " (" + album.getYear() + ")");
    }

    // Finding the oldest album
    Album oldestAlbum = twoDoorCinemaClub.getOldestAlbum();
    if (oldestAlbum != null) {
      System.out.println("\nOldest Album is " + oldestAlbum.getTitle() + " (" + oldestAlbum.getYear() + ")");
    } else {
      System.out.println("\nNo albums found");
    }
  }
}