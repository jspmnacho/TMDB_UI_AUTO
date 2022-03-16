package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Data {

    private String username;
    private String password;
    private String passWrong;
    private String movieName;
    private String genreMovie;


    public Data() {

        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/data.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setUsername(properties.getProperty("user"));
        setPassword(properties.getProperty("password"));
        setPassWrong(properties.getProperty("passWrong"));
        setMovieName(properties.getProperty("movieName"));
        setGenreMovie(properties.getProperty("genreMovie"));

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassWrong() {
        return passWrong;
    }

    public void setPassWrong(String passWrong) {
        this.passWrong = passWrong;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenreMovie() {
        return genreMovie;
    }

    public void setGenreMovie(String genreMovie) {
        this.genreMovie = genreMovie;
    }
}
