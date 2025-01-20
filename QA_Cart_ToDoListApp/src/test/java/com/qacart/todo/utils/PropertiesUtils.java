package com.qacart.todo.utils;

import java.io.*;

public class PropertiesUtils {
    public  static java.util.Properties loadProperties (String filePath) throws IOException {
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        java.util.Properties properties = new java.util.Properties();
        properties.load(inputStream);
        inputStream.close();
        return properties;


    }
}
