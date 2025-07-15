package bookmyshow.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterController {

    Map<City, List<Theatre>> cityVsTheaterMap;
    List<Theatre> allTheatres;

    TheaterController() {
        cityVsTheaterMap = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    void addTheater(Theatre theatre, City city) {
        allTheatres.add(theatre);

        List<Theatre> theatres = cityVsTheaterMap.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheaterMap.put(city, theatres);
    }

    Map<Theatre, List<Show>> getAllShows(Movie movie, City city) {

        Map<Theatre, List<Show>> theaterVsShows = new HashMap<>();
        List<Theatre> theatres = cityVsTheaterMap.get(city);

        for(Theatre theatre : theatres) {
            List<Show> shows = theatre.getShows();
            List<Show> givenMovieShows = new ArrayList<>();

            for(Show show: shows) {
                if (show.getMovie().getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(show);
                }
            }
            if (!givenMovieShows.isEmpty()) {
                theaterVsShows.put(theatre, givenMovieShows);
            }
        }

        return theaterVsShows;
    }
}
