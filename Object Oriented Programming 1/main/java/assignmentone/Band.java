package assignmentone;

import java.util.ArrayList;
import java.util.List;

/**
 * The name of the band.
 */
public class Band {
  private String bandName;
  private int yearFormed;
  private List<Album> albums;

  /**
   * Constructs a Band object with the specified band name and year formed.
   *
   * @param bandName   the name of the band
   * @param yearFormed the year the band was formed
   */
  public Band(String bandName, int yearFormed) {
    this.bandName = bandName;
    this.yearFormed = yearFormed;
    this.albums = new ArrayList<>();
  }
  
  public void addAlbum(String albumName, int releaseYear) {
    Album album = new Album(albumName, releaseYear, this.bandName);
    this.albums.add(album);
  }

  public void addAlbum(Album album) {
    this.albums.add(album);
  }

  // Convert the band's discography to an array and return it
  public Album[] getAlbums() {
    return this.albums.toArray(new Album[0]);
  }

  /**
   * Finds the oldest album in the band's discography.
   *
   * @return the oldest album in the band's discography, or null if the band has no albums.
   */
  public Album getOldestAlbum() {
    // If there are no albums, return null
    if (albums.isEmpty()) {
      return null;
    }
    
    // Assume the first album in the list is the oldest
    Album oldestAlbum = albums.get(0);

    for (Album album : albums) {
      // If the current album's release year is earlier than the oldest album found so far
      if (album.getYear() < oldestAlbum.getYear()) {
        oldestAlbum = album;
      }
    }

    return oldestAlbum;
  }


  // Method to get the band's total discography
  public List<Album> getDiscography() {
    // Return a defensive copy of the list to prevent external modifications
    return new ArrayList<>(albums);
  }

  // Getter methods for bandName and yearFormed
  public String getName() {
    return this.bandName;
  }

  public int getYear() {
    return yearFormed;
  }

}
