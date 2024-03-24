package assignmentone;

/**
 * This class represents an album.
 */
public class Album {
  // Private = they can only be accessed inside this class.
  private String name;
  private int releaseYear;
  private String artist;


  // Constructor = initializes the parameters 
  /**
   * Constructs an Album object with the specified name, release year, and artist.
   *
   * @param albumName       the name of the album
   * @param releaseYear    the release year of the album
   * @param theArtist     the artist of the album
   */
  public Album(String albumName, int releaseYear, String theArtist) {
    setName(albumName);
    setYear(releaseYear);
    setArtist(theArtist);
  }

  /**
   * Sets the name of the album.
   *
   * @param theName the name of the album
   */
  public void setName(String theName) {
    if (theName != null && theName.length() >= 4) {
      this.name = theName;
    } else {
      this.name = "No name";
    }
  }

  /**
   * Returns the name of the album.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the title of the album (which is the same as the name).
   */
  public String getTitle() {
    return name;
  }

  /**
   * Sets the release year of the album.
   *
   * @param thereleaseYear the release year of the album
   */
  public void setYear(int thereleaseYear) {
    if (thereleaseYear <= 1800 || thereleaseYear > 2029) {
      this.releaseYear = -1;
    } else {
      this.releaseYear = thereleaseYear;
    }
  }

  /**
   * Getter method for the releaseYear.
   * It returns the release year of the album.
   */
  public int getYear() {
    return releaseYear;
  }

  /**
   * Sets the artist of the album.
   *
   * @param theArtist the artist of the album
   */
  public void setArtist(String theArtist) {
    if (theArtist == null || theArtist.isEmpty()) {
      this.artist = "No artist";
    } else {
      this.artist = theArtist;
    }
  }

  /**
   * Getter method for the artist.
   * It returns the artist of the album.
   */
  public String getArtist() {
    return artist;
  }
}