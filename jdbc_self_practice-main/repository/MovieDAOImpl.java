package repository;

import model.Movie;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieDAOImpl implements MovieDAO{
    private Connection connection;

    public MovieDAOImpl() {
        connection = DBUtil.getDBConnection();
    }

    @Override
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Movies(id INTEGER AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), genre VARCHAR(255), yearOfRelease INTEGER)";

        try (Statement statement = connection.createStatement()){
            statement.execute(sql);
        } catch (SQLException throwables) {
            throw new DatabaseActionExeption(throwables);
        }
    }

    @Override
    public void deleteTable() {
        String sql = "DROP TABLE Movies";

        try (Statement statement = connection.createStatement()){
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void createMovie(Movie movie) {
        String sql = "INSERT INTO Movies(title, genre, yearOfRelease) VALUES(?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getTitle());
            preparedStatement.setInt(3, movie.getYearOfRelease());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DatabaseActionExeption(throwables);
        }
    }

    @Override
    public void deleteMovie(int id) {
        String sql = "DELETE FROM Movies WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DatabaseActionExeption(throwables);
        }
    }

    @Override
    public void updateMoviesTitle(int id, String newTitle) {
        String sql = "UPDATE Movies SET title = ? WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, newTitle);
            preparedStatement.setInt(2, id);
        } catch (SQLException throwables) {
            throw new DatabaseActionExeption(throwables);
        }
    }

    @Override
    public Optional<Movie> findMovieById(int id) {
        String sql = "SELECT * FROM Movies WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            final boolean searchResult = preparedStatement.execute();
            if (searchResult){
                ResultSet foundMovie = preparedStatement.getResultSet();
                if (foundMovie.next()){
                    String title = foundMovie.getString("title");
                    String genre = foundMovie.getString("genre");
                    int yearOfRelease = foundMovie.getInt("yearOfRelease");
                    return Optional.of(new Movie(id, title, genre, yearOfRelease));
                }
            }
            return Optional.empty();
        } catch (SQLException throwables) {
            throw new DatabaseActionExeption(throwables);
        }
    }

    @Override
    public List<Movie> findAll() {
        List <Movie> movieList = new ArrayList<>();
        Movie movieResult = null;

        String sql = "SELECT * FROM MOVIES";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                movieResult = new Movie();
                movieResult.setId(resultSet.getInt("id"));
                movieResult.setTitle(resultSet.getString("title"));
                movieResult.setGenre(resultSet.getString("genre"));
                movieResult.setYearOfRelease(resultSet.getInt("yearOfRelease"));

                movieList.add(movieResult);
            }
        } catch (SQLException throwables) {
            throw new DatabaseActionExeption(throwables);
        }

        return movieList;
    }
}
