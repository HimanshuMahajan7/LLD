package bookmyshow.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {

    Map<City, List<Movie>> cityVsMovies;
    List<Movie> allMovies;

    MovieController(){
        cityVsMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    void addMovie(Movie movie, City city) {
        allMovies.add(movie);
        List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovies.put(city, movies);
    }

    Movie getMovieByName(String movieName) {
        Movie movie = allMovies.stream()
                .filter(eachMovie -> eachMovie.getMovieName().equals(movieName))
                .toList()
                .getFirst();
        return movie;
    }

    List<Movie> getMoviesByCity(City city) {
        return cityVsMovies.get(city);
    }

    // REMOVE movie from a particular city
    // UPDATE movie of a particular city
    // CRUD operation based on Movie ID
}
