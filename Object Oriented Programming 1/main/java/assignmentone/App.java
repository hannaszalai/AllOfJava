package assignmentone;

import java.util.Scanner; // used for user input

/**
 * This is the main class for the assignment.
 */
public class App {
  private Scanner input;

  private App(Scanner scannerInput) {
    this.input = scannerInput;
  }

  /**
   * Solution to first task.
   */
  public void helloThere() {
    System.out.println("Task 1:");
    System.out.print("Name, please: ");
    String name = input.nextLine(); // nextLINE if string

    HelloThere helloThere = new HelloThere();
    String myname = helloThere.hello(name);
    System.out.println(myname);
  }

  /**
    * Solution for the second task.
    */
  public void seconds() {
    System.out.println("\n Task 2:");
    System.out.print("Enter hours, minutes and seconds: ");
    int hours = input.nextInt();  //nextINT if integer
    int minutes = input.nextInt();
    int seconds = input.nextInt();
    input.nextLine(); // Consume newline left-over

    Time time = new Time();
    int totalSeconds = time.toSeconds(hours, minutes, seconds);
    System.err.println("In only seconds that is: " + totalSeconds);
  }

  /**
   * Solution for the third task.
   */
  public void imInaBand() {
    System.out.println("\n Task 3:");
    Album album = new Album("Wish You Were Here", 1975, "Pink Floyd");
    System.err.println(album.getName() + " was released in " + album.getYear() + " by " + album.getArtist());
  }

  /**
   * Solution for the fourth task.
   */
  public void bestAlbumsEver() {
    System.out.println("\n Task 4:");
    AlbumGenerator generator = new AlbumGenerator();
    Album[] albums = generator.generateAlbums();
    for (Album album : albums) {
      System.out.println(album.getName() + " was released in " + album.getYear() + " by " + album.getArtist());
    }
  }

  /**
   * Solution for the fifth task.
   */
  public void workingWithArrays() {
    System.out.println("\n Task 5:");

    ArrayAlgorithms arrayalgo = new ArrayAlgorithms();
    int[] array = {5, 2, 6, 4, 1, 3, 7, 9, 8};

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println("\n" + "Average is: " + arrayalgo.average(array));
    System.out.println("Largest value is: " + arrayalgo.maxValue(array));
    System.out.println("Index of smallest value is at position: " + arrayalgo.minIndex(array));

    System.out.print("Shifted array: \n");
    for (int num : arrayalgo.shift(array)) {
      System.out.print(num + " ");
    }
    System.out.println();
  
    System.out.print("Shuffled array: \n");
    for (int num : arrayalgo.shuffle(array)) {
      System.out.print(num + " ");
    }
    System.out.println();

    int[][] array2D = {{5, 2, 6}, {4, 1, 3}, {7, 9, 8}};
    ArrayAlgorithms arrayalgo2D = new ArrayAlgorithms();

    System.out.println("Sum of 2D array elements: " + arrayalgo2D.sum(array2D));

    System.out.println("Transposed 2D array: ");
    int[][] transposedArray = arrayalgo2D.transpose(array2D);
    for (int[] row : transposedArray) {
      for (int num : row) {
        System.out.print(num + " ");
      }
      System.out.println();
    }

    System.out.println("Sum of diagonal elements: " + arrayalgo2D.diagonalSum(array2D));

  }

  /**
   * Starting point of the first assignment.
   *
   * @param args is not used.
   */
  public static void main(String[] args) {

    // we create a scanner object to work with
    // it is advised to create one and only one scanner for a specific stream in the whole 
    // application scanners should be closed when you are done and this also closes 
    // the underlying stream
    Scanner consoleInput = new Scanner(System.in, "UTF-8");

    App app = new App(consoleInput);

    // Task 1
    app.helloThere();

    // Task 2
    app.seconds();

    // Task 3
    app.imInaBand();

    // Task 4 
    app.bestAlbumsEver();

    // Task 5
    app.workingWithArrays();


    // If you are going for the higher grades you can uncomment the following lines
    // and implement the methods in the GradeC class.
    GradeC gradeC = new GradeC();
    gradeC.calculator(consoleInput);
    gradeC.band();

    GradeA gradeA = new GradeA();
    gradeA.calculator(consoleInput);
    gradeA.arrays3D();
    // gradeA.genre();


    // now we are exiting the application so time to close the scanner.
    consoleInput.close();
  }
}
