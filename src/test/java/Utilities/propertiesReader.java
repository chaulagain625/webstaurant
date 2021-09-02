package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertiesReader {
    String path = System.getProperty("user.dir");
    static Properties properties;

    /**
     * This method is use to read the properties of configuration file.
     * @param filePath it takes a file path
     * @return and return the properties from that file
     */

    public static Properties readProperties(String filePath){
        try {
            FileInputStream fileInputStream= new FileInputStream(filePath);
            properties=new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * This method used to get the actual value when we pass the key
     * @param key
     * @return
     */
    public static String getPropertyValue(String key){
       return properties.getProperty(key);
    }
}
