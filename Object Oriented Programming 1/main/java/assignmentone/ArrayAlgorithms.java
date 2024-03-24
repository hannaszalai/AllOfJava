package assignmentone;

import java.util.Random;  //import random, capital R bc it's a class


/**
 * Returns the average value of all the containing integers.
 */
public class ArrayAlgorithms {
  /**
   * Returns the average value of all the elements in the array.
   *
   * @param array the array of integers
   * @return the average value
   */
  //int[] array = array of integers (array is a chosen name)
  public double average(int[] array) {
    double sum = 0;  // To store 
    // Loop through each element in the array
    for (int num : array) {
      // Add the current element to the sum
      sum += num;  // sum is the first bc num is a temporarly element
    }

    // We cast the sum to double before division to get a precise result.
    // If we don't cast to double, integer division would be performed which shortens the decimal part.
    // () to convert a data type to another
    return (double) sum / array.length;
  }

  /**
   * Returns the largest value in the array.
   */
  public int maxValue(int[] array) {
    // Initialize 'max' with the first element of the array
    // To keep track of the highest value found so far.
    int max = array[0];
    // Iterate over each element in the array
    for (int num : array) {
      // If the current element 'num' is greater than the current 'max', update 'max'
      if (num > max) {
        max = num;
      }
    }
    return max;
  }

  public int maxValue(int[][][] array) {
    return maxValue3D(array);
  }

  /**
   * Returns the maximum value in a 3D array.
   *
   * @param array the 3D array of integers
   * @return the maximum value in the array
   */
  public int maxValue3D(int[][][] array) {
    int max = Integer.MIN_VALUE;
    for (int[][] matrix : array) {
      for (int[] row : matrix) {
        for (int num : row) {
          if (num > max) {
            max = num;
          }
        }
      }
    }
    return max;
  }

  /**
   * Returns the index number of the element that is the smallest.
   */
  public int minIndex(int[] array) {
    int minIndex = 0;  // To store
    // Start at 1 because we have already assumed that the first element of the array is the smallest
    // The loop will iterate over each element in the array, from the second element to the last
    for (int i = 1; i < array.length; i++) {
      // Inside the loop, for each iteration, we compare the current element with the smallest element found so far
      if (array [i] < array[minIndex]) {
        minIndex = i;
      }
    }
    return minIndex;
  }

  public int minValue(int[][][] array) {
    return minValue3D(array);
  }

  /**
   * Shifts the elements of the array to the left by one position.
   *
   * @param array the array of integers
   * @return the shifted array
   */
  public int[] shift(int[] array) {
    int firstElement = array[0];  // To store
    // Initialize the loop counter to 0
    // The loop will iterate over from the first element to the second last
    for (int i = 0; i < array.length - 1; i++) {
      // Shift the elements to the left
      array[i] = array[i + 1];
    }
    // Put the first element to the end
    array[array.length - 1] = firstElement;
    return array;
  }

  /**
   * Shuffles the elements of the array randomly.
   *
   * @param array the array of integers
   * @return the shuffled array
   */
  public int[] shuffle(int[] array) {
    // Generate random numbers
    Random rand = new Random();
    // Iterate over a loop
    for (int i = 0; i < array.length; i++) {
      // Generate a random index within the range of the array
      int randomIndex = rand.nextInt(array.length);

      int current = array[i]; // Store the current element
      array[i] = array[randomIndex]; // Overwrite the random element with the current index
      // Completes the shuffle - 
      // by setting the element at the randomIndex to the original value of the current element
      array[randomIndex] = current;
    }
    return array;
  }

  /**
   * Calculates the sum of all elements in a 2D array.
   *
   * @param array the 2D array of integers
   * @return the sum of all elements in the array
   */
  public int sum(int[][] array) {
    int total = 0;  // To store
    // The outer loop iterates over each 1D array (row)
    for (int[] row : array) {
      // The inner loop iterates over each element in the outer loop
      for (int num : row) {
        total += num;
      }
    }
    return total;
  }

  /**
   * Calculates the sum of all elements in a 3D array.
   *
   * @param numbers the 3D array of integers
   * @return the sum of all elements in the array
   */
  public int sum(int[][][] numbers) {
    int sum = 0;
    for (int[][] array2D : numbers) {
      for (int[] array1D : array2D) {
        for (int number : array1D) {
          sum += number;
        }
      }
    }
    return sum;
  }

  /**
   * Calculates the sum of all elements in a 3D array.
   *
   * @param array the 3D array of integers
   * @return the sum of all elements in the array
   */
  public int sum3D(int[][][] array) {
    int total = 0;
    for (int[][] matrix : array) {
      for (int[] row : matrix) {
        for (int num : row) {
          total += num;
        }
      }
    }
    return total;
  }

  /**
   * Transposes a given 2D array.
   *
   * @param array the 2D array to be transposed
   * @return the transposed 2D array
   */
  public int[][] transpose(int[][] array) {
    // Check if the array is not a square matrix
    if (array.length != array[0].length) {      
      // If it's not a square matrix, return the original array
      return array;
    }

    // Create a new 2D array
    int[][] transposed = new int[array[0].length][array.length];
    // The outer loop iterates over each row in the original 2D array.
    for (int i = 0; i < array.length; i++) {
      // The inner loop iterates over each column in the original 2D array.
      for (int j = 0; j < array[i].length; j++) {
        // This swaps the rows and columns
        transposed[j][i] = array[i][j];
      }
    }
    return transposed;
  }

  /**
   * Calculates the sum of the elements on the diagonal of a square matrix.
   *
   * @param array the square matrix
   * @return the sum of the diagonal elements
   */
  public int diagonalSum(int[][] array) {
    // Check if the input 2D array is a square matrix
    if (array.length != array[0].length) {
      return 0;
    }
    int sum = 0;  // To store
    // Iterate over the 2D array. Since it's a square matrix, we can just loop from 0 to array.length
    for (int i = 0; i < array.length; i++) {
      // Refers to the element at the ith row and ith column
      // Adding up all the elements on the diagonal of the square matrix
      sum += array[i][i];
    }
    return sum;
  }

  /**
   * Returns the minimum value in a 3D array.
   *
   * @param array the 3D array of integers
   * @return the minimum value in the array
   */
  public int minValue3D(int[][][] array) {
    int min = Integer.MAX_VALUE;
    for (int[][] matrix : array) {
      for (int[] row : matrix) {
        for (int num : row) {
          if (num < min) {
            min = num;
          }
        }
      }
    }
    return min;
  }
}