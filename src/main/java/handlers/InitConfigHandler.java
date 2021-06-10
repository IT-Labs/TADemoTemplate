package handlers;

import java.io.*;
import java.util.*;

public class InitConfigHandler {

    public static final Set<String> listOS = new HashSet<>();

    static {
        listOS.add("windows");
        listOS.add("mac");
    }

    public static String getCurrentOS() {
        return System.getProperty("os");
    }

    public static void checkAndValidatedOS() {
        if (listOS.contains(getCurrentOS())){
            System.out.println("Hello from " + getCurrentOS());
        } else {
            System.out.println("*****************************************************************************************");
            System.out.println("Entered " + "" + getCurrentOS() + "" + " operating system not supported or you have a typing error!");
            System.out.println("*****************************************************************************************");
        }
    }

    public static HashMap<String, String> getInitialConfigProperties(){
        HashMap<String, String> localConfigProperties = new HashMap<>();
        localConfigProperties.put("os", System.getProperty("os"));
        localConfigProperties.put("browserName", System.getProperty("browserName"));
        localConfigProperties.put("environment", System.getProperty("environment"));
        localConfigProperties.put("suiteXmlFile", System.getProperty("suiteXmlFile"));

        return localConfigProperties;
    }


    public static HashMap <String, String> loadEnvironmentConfigurationFile(){
        String propFileName = "";
        Properties properties;

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
                throw new IOException("Not able to read " + propFileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propFileName);
        }

        System.out.println("Property file name: " + propFileName);
        HashMap<String, String> configProperties = new HashMap<>();
        configProperties.put("url", properties.getProperty("url"));

        return configProperties;
    }
}