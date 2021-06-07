package handlers;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class InitConfigHandler {

    public static HashMap<String, String> initialPropertiesMap;
    static {
        try {
            initialPropertiesMap = InitConfigHandler.loadEnvironmentConfigurationFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> getInitialConfigProperties(){
        HashMap<String, String> localConfigProperties = new HashMap<String, String>();
        localConfigProperties.put("os", System.getProperty("os"));
        localConfigProperties.put("browserName", System.getProperty("browserName"));
        localConfigProperties.put("environment", System.getProperty("environment"));
        localConfigProperties.put("suiteXmlFile", System.getProperty("suiteXmlFile"));

        return localConfigProperties;
    }

    public static HashMap loadEnvironmentConfigurationFile() throws IOException {
        String propFileName = "";
        Properties properties = new Properties();

        switch (System.getProperty("environment")) {
            case "live":
                propFileName = "live.properties";
                break;
            case "test":
                propFileName = "staging.properties";
                break;
            case "staging":
                propFileName = "test.properties";
                break;
        }

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("environments/" + propFileName));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propFileName);
        }

        System.out.println("Property file name: " + propFileName);
        HashMap<String, String> configProperties = new HashMap<String, String>();
        configProperties.put("url", properties.getProperty("url"));

        return configProperties;
    }
}