package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static String username;
    private static String password;
    private static int port;
    private static String basePath;
    private static String URI;
    private static String URL;
    private Properties properties;

    public PropertiesReader(String propertiesLocation){
        loadFile(propertiesLocation);
        loadData();
    }

    private void loadFile(String propertiesLocation) {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(propertiesLocation));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("There is something wrong with the file. Does it exist? "+
                    "File location: " + propertiesLocation);
        }
    }

    private void loadData(){
        username=properties.getProperty("username");
        password=properties.getProperty("password");
        port=Integer.parseInt(properties.getProperty("port"));
        basePath=properties.getProperty("basePath");
        URI=properties.getProperty("URI");
        URL=properties.getProperty("URL");
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static int getPort() {
        return port;
    }

    public static String getBasePath() {
        return basePath;
    }

    public static String getURI() {
        return URI;
    }

    public static String getURL() {
        return URL;
    }
}
