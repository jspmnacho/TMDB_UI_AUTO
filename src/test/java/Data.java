import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.Properties;

public class Data {

    private String username;
    private String password;


    public Data() {

        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/data.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setUsername(properties.getProperty("user"));
        setPassword(properties.getProperty("password"));

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
}
