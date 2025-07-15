package bookmyshow.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheaterController theaterController;

    public BookMyShow() {
        this.movieController = new MovieController();
        this.theaterController = new TheaterController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        bookMyShow.createBooking(City.Pune, "BAAHUBALI");
        bookMyShow.createBooking(City.Pune, "BAAHUBALI");
    }

    private void createBooking(City userCity, String movieName) {
        List<Movie> moviesByCity = movieController.getMoviesByCity(userCity);

        Movie interestedMovie = null;
        for (Movie movie: moviesByCity) {
            if (movie.getMovieName().equals(movieName)) {
                interestedMovie = movie;
            }
        }

        //3. get all show of this movie in Bangalore location
        Map<Theatre, List<Show>> showsTheatreWise = theaterController.getAllShows(interestedMovie, userCity);

        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        //5. select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeats();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if(screenSeat.getSeatId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");

    }

    private void initialize() {
        createMovies();
        createTheaters();
    }

    private void createTheaters() {
        Movie avengerMovie = movieController.getMovieByName("AVENGERS");
        Movie baahubaliMovie = movieController.getMovieByName("BAAHUBALI");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheaterId(1);
        inoxTheatre.setScreen(createScreen());
        inoxTheatre.setCity(City.Mumbai);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShow(1, inoxTheatre.getScreen().getFirst(), avengerMovie, 13);
        Show inoxEveningShow = createShow(2, inoxTheatre.getScreen().getFirst(), baahubaliMovie, 20);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShows(inoxShows);

        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheaterId(2);
        pvrTheatre.setScreen(createScreen());
        pvrTheatre.setCity(City.Pune);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShow(3, pvrTheatre.getScreen().getFirst(), avengerMovie, 10);
        Show pvrEveningShow = createShow(4, pvrTheatre.getScreen().getFirst(), baahubaliMovie, 18);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);

        theaterController.addTheater(inoxTheatre, City.Mumbai);
        theaterController.addTheater(pvrTheatre, City.Pune);
    }

    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();

        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());

        screens.add(screen1);
        return screens;
    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;
    }

    private Show createShow(int showId, Screen screen, Movie movie, int showStartTime) {
        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setStartTime(showStartTime);
        return show;
    }

    private void createMovies() {

        // Create Movie 1
        Movie avengers = new Movie();
        avengers.setMovieId(1);
        avengers.setMovieName("AVENGERS");
        avengers.setMovieDurationInMinutes(150);

        // Create Movie 2
        Movie baahubali = new Movie();
        baahubali.setMovieId(2);
        baahubali.setMovieName("BAAHUBALI");
        baahubali.setMovieDurationInMinutes(180);

        movieController.addMovie(avengers, City.Mumbai);
        movieController.addMovie(avengers, City.Pune);
        movieController.addMovie(baahubali, City.Mumbai);
        movieController.addMovie(baahubali, City.Pune);
    }
}
