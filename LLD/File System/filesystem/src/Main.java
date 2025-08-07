package filesystem.src;

public class Main {
    public static void main(String[] args) {
        Directory movieDirectory = new Directory("Movie");

        File kaal = new File("Kaal");
        movieDirectory.add(kaal);

        Directory comedyMovieDirectory = new Directory("Comedy Movie");
        File hulchul = new File("Hulchul");
        comedyMovieDirectory.add(hulchul);

        movieDirectory.add(comedyMovieDirectory);
        movieDirectory.ls();
    }
}
