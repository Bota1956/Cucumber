package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String readProperty(String key){

        //File class assign given file to the java object.
        File file= new File("configuration.properties"); // it has to be location of the file (file path)
         //you can put anything like word,text file, pdf file, xml file etc.. what format your file.
        Properties properties = new Properties();// properties object will read the properties file, comes from java
        try {
            properties.load(new FileInputStream(file)); // it will open the file
            //load method will load every value from file object to properties object.
        } catch (IOException e) {
            e.printStackTrace();
        }
     return properties.getProperty(key);// I can read the value from properties object using the key.

    }
}
