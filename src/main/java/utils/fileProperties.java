package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class fileProperties {
    public Properties getProperty(){
        Properties properties =new Properties();

        String  filePath = new File("parametros.properties").getAbsolutePath();
        File file = new File(filePath);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            properties.load(fileInput);
        } catch (IOException e){
            e.printStackTrace();
        }
        return properties;
    }
}
