package org.example.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Singleton {
    private static Singleton singleton;
    private Properties properties = new Properties();

    private Singleton() {
        try {
            File file = new File("src/main/resources/config.properties");
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
    public String getProperties(String key){
        return properties.getProperty(key);
    }

}
