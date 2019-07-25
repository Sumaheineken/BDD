package com.heineken.HAT.core.config;

import com.heineken.HAT.core.enumManage.DriverType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by mohana on 5/8/2019.
 */
public class RuntimeConfiguration {

    private Properties properties;
    private final String propertyFilePath= GlobalConstants.PROPERTY_FILE_PATH;


    public RuntimeConfiguration(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("URL");
        if(url != null) return url;
        else throw new RuntimeException("Url not specified in the Configuration.properties file.");
    }

    public String getIEDriverPath(){
        String driverPath = properties.getProperty("IEDriverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("IE driverPath not specified in the Configuration.properties file.");
    }

    public String getChromeDriverPath(){
        String driverPath = properties.getProperty("ChromeDriverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("Chrome driverPath not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if(browserName.equals("ie")) return DriverType.INTERNETEXPLORER;
        else if(browserName.equals("ie_remote")) return DriverType.INTERNETEXPLORER_REMOTE;
        else if(browserName.equals("chrome_remote")) return DriverType.CHROME_REMOTE;
        else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    public String getHubURL(){
        String hubUrl = properties.getProperty("hubURL");
        if(hubUrl!= null) return hubUrl;
        else throw new RuntimeException("Hub URL not specified in the Configuration.properties file.");
    }

}
