package assignmentone;

// import java.util.List;
import java.util.Scanner;

/**
 * This is the class for the A grade part of the assignment.
 */
public class GradeA {
    
  /**
   * Solution to the calcutlator task.
   *
   * @param input is the scanner used to read input from the user.
   */
  public void calculator(Scanner input) {
    Calculator calculator = new Calculator();
    System.out.print("\nTask 8: \n");
    System.out.print("Enter a number: ");
    double num = input.nextDouble();

    System.out.println("Select an operation (square, sqrt, factorial, add, subtract, multiply, divide): ");
    String operation = input.next();

    double result = 0.0;
    switch (operation) {
      case "square":
        result = calculator.sqrt(num);
        break;
      case "sqrt":
        result = calculator.sqrt(num);
        break;
      case "factorial":
        if (num >= 0 && (int) num == num) {
          result = calculator.factorial((int) num);
        } else {
          System.out.println("Invalid input for factorial!");
          return;
        }
        break;
      case "add":
        System.out.print("Enter another number: ");
        double n1 = input.nextDouble();
        result = calculator.add(num, n1);
        break;
      case "subtract":
        System.out.print("Enter another number: ");
        double n2 = input.nextDouble();
        result = calculator.subtract(num, n2);
        break;
      case "multiply":
        System.out.print("Enter another number: ");
        double n3 = input.nextDouble();
        result = calculator.multiply(num, n3);
        break;
      case "divide":
        System.out.print("Enter another number: ");
        double n4 = input.nextDouble();
        result = calculator.divide(num, n4);
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
   * Solution to the 3D arrays task.
   */
  public void arrays3D() {
    // Create a 3D array for demonstration
    int[][][] array = {
        {
          {1, 2, 3},
          {4, 5, 6},
          {7, 8, 9}
        },
        {
          {10, 11, 12},
          {13, 14, 15},
          {16, 17, 18}
        },
        {
          {19, 20, 21},
          {22, 23, 24},
          {25, 26, 27}
        }
      };
  

    ArrayAlgorithms arrayAlgorithms = new ArrayAlgorithms();
    // Use the methods defined earlier
    int sum = arrayAlgorithms.sum3D(array);
    int max = arrayAlgorithms.maxValue3D(array);
    int min = arrayAlgorithms.minValue3D(array);
  
    // Print the results
    System.out.print("\nTask 9: \n");
    System.out.println("Sum of 3D array: " + sum);
    System.out.println("Max of 3D array: " + max);
    System.out.println("Min of 3D array: " + min);
  }
  
  //   /**
  //    * Solution to the genre task.
  //    */
  //   public void genre() {
  //     // Create a band and add albums to it
  //     Band pinkFloyd = new Band();
  //     pinkFloyd.addAlbum(new Album("Dark Side of the Moon", 1973, "Pink Floyd"));
  //     pinkFloyd.addAlbum(new Album("Wish You Were Here", 1975, "Pink Floyd"));
  //     pinkFloyd.addAlbum(new Album("Animals", 1977, "Pink Floyd"));
  //     pinkFloyd.addAlbum(new Album("The Wall", 1979, "Pink Floyd"));

  //     Band twoDoorCinemaClub = new Band();
  //     twoDoorCinemaClub.addAlbum(new Album("Tourist History", 2010));
  //     twoDoorCinemaClub.addAlbum(new Album("Beacon", 2012));
  //     twoDoorCinemaClub.addAlbum(new Album("Gameshow", 2016));
  //     twoDoorCinemaClub.addAlbum(new Album("False Alarm", 2019));
  //     twoDoorCinemaClub.addAlbum(new Album("Keep On Smiling", 2022));

  //     // Set genres for the bands
  //     for (Album album : pinkFloyd.getAlbums()) {
  //       album.setGenre("Alternative Rock");
  //     }

  //     for (Album album : twoDoorCinemaClub.getAlbums()) {
  //       album.setGenre("Indie");
  //     }

  //     // Print all albums of a particular genre
  //     List<Album> altRockAlbums = pinkFloyd.getAlbumsByGenre("Alternative Rock");
  //     System.out.println("\nAlternative Rock Albums:");
  //     for (Album altRockAlbum : altRockAlbums) {
  //       System.out.println(altRockAlbum.getName());
  //     }

  //     List<Album> indieAlbums = twoDoorCinemaClub.getAlbumsByGenre("Indie");
  //     System.out.println("\nIndie Albums:");
  //     for (Album indieAlbum : indieAlbums) {
  //       System.out.println(indieAlbum.getName());
  //     }
  //   }

}