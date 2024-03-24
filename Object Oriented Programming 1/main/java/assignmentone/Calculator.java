package assignmentone;

/**
 * A flag to track if the last division operation attempted division by zero.
 */
public class Calculator {
  private boolean isDivideByZero = false;

  public double add(double n1, double n2) {
    return n1 + n2;
  }

  public double subtract(double n1, double n2) {
    return n1 - n2;
  }

  public double multiply(double n1, double n2)  {
    return n1 * n2;
  }

  /**
   * Divides two numbers and sets isDivideByZero to true if the second number is zero.
   *
   * @param n1 the dividend
   * @param n2 the divisor
   * @return the quotient of the division
   */
  public double divide(double n1, double n2) {
    // Sets isDivideByZero to true if the second number is zero
    if (n2 != 0) {
      isDivideByZero = false;
      return n1 / n2;
    } else {
      isDivideByZero = true;
      return Double.NaN;
    }
  }

  // Returns whether the last division operation attempted division by zero
  public boolean isDivideByZero() {
    return isDivideByZero;
  }

  /**
   * Calculates the square of a given number.
   */
  public double square(double number) {
    return number * number;
  }


  /**
   * Calculates the square root of a given number.
   *
   * @param number the number to calculate the square root of
   * @return the square root of the given number
   */
  public double sqrt(double number) {
    // If the number is negative, returns 0.
    if (number < 0) {
      return 0.0;
    }
    return Math.sqrt(number);
  }

  /**
   * Calculates the factorial of a given number.
   *
   * @param n the number to calculate the factorial of
   * @return the factorial of the given number
   */
  public long factorial(int n) {
    long result = 1;
    for (int i = 2; i <= n; i++) {
      result *= i;
    }
    return result;
  }
}
