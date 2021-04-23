package repository;

import model.Movie;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryMovie {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public RepositoryMovie(){
        connection = DBUtil.getDBConnection();
    }

    public void saveMovie(Movie movie){
        String sql = "INSERT INTO MOVIES(title, genre, yearOfRelease) "+
                "VALUES(?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getGenre());
            preparedStatement.setInt(3, movie.getId());

            int result = preparedStatement.executeUpdate();

            if (result > 0) System.out.println("New movie "+ movie.getTitle() + " was added to DB jbdb_movies");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateMovieById(Movie movie){
        String sql = "UPDATE MOVIES SET title = ?, genre = ?, yearOfRelease = ? "+
                "WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getGenre());
            preparedStatement.setInt(3, movie.getYearOfRelease());
            preparedStatement.setInt(4, movie.getId());

            int result = preparedStatement.executeUpdate();

            if (result > 0) System.out.println("Movie has been updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteMovie(int id){
        String sql = "DELETE FROM MOVIES WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int result = preparedStatement.executeUpdate();
            if(result > 0) System.out.println("Movie with id " + id + " was deleted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Movie> findAllMovies(){
        List <Movie> movieList = new ArrayList<>();
        Movie movieResult = null;

        String sql = "SELECT * FROM MOVIES";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                movieResult = new Movie();
                movieResult.setId(resultSet.getInt("id"));
                movieResult.setTitle(resultSet.getString("title"));
                movieResult.setGenre(resultSet.getString("genre"));
                movieResult.setYearOfRelease(resultSet.getInt("yearOfRelease"));

                movieList.add(movieResult);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return movieList;
    }
}
