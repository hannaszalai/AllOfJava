package assignmentone;

/**
 * This class generates albums.
 */
public class AlbumGenerator {
  /**
   * Generates an array of albums.
   *
   * @return an array of albums
   */
  public Album[] generateAlbums() {
    // Create an array of Album object with a size of 4
    Album[] albums = new Album[4];
    albums[0] = new Album("Dark Side of the Moon", 1973, "Pink Floyd");
    albums[1] = new Album("Wish You Were Here", 1975, "Pink Floyd");
    albums[2] = new Album("Animals", 1977, "Pink Floyd");
    albums[3] = new Album("The Wall", 1979, "Pink Floyd");
    return albums;
  }
}
