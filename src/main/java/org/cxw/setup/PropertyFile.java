package org.cxw.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFile {

    public static String readProperty(String property) {

        String result = "";
        String FileURL = "./src/resources/config.properties";
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            File initialFile = new File(FileURL);
            inputStream = new FileInputStream(initialFile);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file not found in the classpath");
            }
            result = prop.getProperty(property);
            inputStream.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            // final action ---
        }
        return result;
    }
}
