package assignmentone;

/**
 * Converts the given time to seconds.
 *
 * @param hours the number of hours.
 * @param minutes the number of minutes.
 * @param seconds the number of seconds.
 * @return the total number of seconds.
 */
public class Time {
  public int toSeconds(int hours, int minutes, int seconds) {
    return hours * 3600 + minutes * 60 + seconds;
  }
}
