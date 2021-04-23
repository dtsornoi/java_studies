package main;

import model.Movie;
import repository.MovieDAOImpl;
import repository.RepositoryMovie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Movie lotr1 = new Movie();
        lotr1.setTitle("Lord Of The Rings: Fellowship of the Ring");
        lotr1.setGenre("Fantasy");
        lotr1.setYearOfRelease(2001);

        Movie hp1 = new Movie();
        hp1.setTitle("Harry Potter: And the Philosophers Stone");
        hp1.setGenre("Fantasy");
        hp1.setYearOfRelease(2001);

        Movie ff = new Movie();
        ff.setTitle("Fast and Furious");
        ff.setGenre("Action");
        ff.setYearOfRelease(2001);

        Movie ff9 = new Movie();
        ff9.setTitle("Fast and Furious 9");
        ff9.setGenre("Action");
        ff9.setYearOfRelease(2021);
        ff9.setId(3);

        MovieDAOImpl movieDAO = new MovieDAOImpl();
        movieDAO.deleteTable();
//        movieDAO.createTable();
//        movieDAO.createMovie(new Movie("lotr1", "fantasy", 2001));
//        movieDAO.createMovie(new Movie("hp1", "fantasy", 2001));
//        movieDAO.createMovie(new Movie("ff", "action", 2001));
//        List <Movie> movies = movieDAO.findAll();
//        RepositoryMovie repositoryMovie = new RepositoryMovie();

//        repositoryMovie.saveMovie(ff);
//        repositoryMovie.deleteMovie(4);
//        repositoryMovie.updateMovieById(ff9);
//
//        List<Movie> movies = repositoryMovie.findAllMovies();
//
//        for(Movie movie : movies){
//            System.out.println(movie.toString());
//        }
    }
}
