package com.firstname_lastname.java.lesson3;

/**
 * Property file class operation
 *
 * @version 1.0
 * @author FIO
 */


import java.util.ResourceBundle;

public class PropertiesFile {
    String fileProperties = "resource/config.properties";

    public PropertiesFile() {

        FileOperation fo = new FileOperation();
        fileProperties = fo.normalizePath(fileProperties);
    }

    public String readProperties(String readValue) {

        String result = "";
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
            result = resourceBundle.getString(readValue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
