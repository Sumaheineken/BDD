package com.heineken.HAT.core.config;

import com.heineken.HAT.core.enumManage.DriverType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
* Created by mohana on 5/8/2019.
*/
public class WebDriverSession {

    private WebDriver driver = null;
    private static DriverType driverType;
    private static final String CHROME_DRIVER_PROPERTY =GlobalConstants.CHROME_DRIVER_PROPERTY;
    private static final String IE_DRIVER_PROPERTY = GlobalConstants.IE_DRIVER_PROPERTY;

    public WebDriverSession() {
        driverType = FileReaderManager.getInstance().getRuntimeConfiguration().getBrowser();
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WINDOWS);
        String hubURL = FileReaderManager.getInstance().getRuntimeConfiguration().getHubURL();
        switch (driverType) {
            case INTERNETEXPLORER:
                System.setProperty(IE_DRIVER_PROPERTY, FileReaderManager.getInstance().getRuntimeConfiguration().getIEDriverPath());
                capabilities.setCapability("ignoreZoomSetting", true);
                capabilities.setCapability("requireWindowFocus", true);
                capabilities.setCapability("enablePersistentHover", false);
                capabilities.setCapability("requireWindowFocus", false);
                driver = new InternetExplorerDriver(capabilities);
                break;
            case INTERNETEXPLORER_REMOTE:
                capabilities.setBrowserName("internet explorer");
                capabilities.setCapability("ignoreZoomSetting", true);
                capabilities.setCapability("requireWindowFocus", true);
                capabilities.setCapability("enablePersistentHover", false);
                capabilities.setCapability("requireWindowFocus", false);
                try {
                    driver = new RemoteWebDriver(new URL(hubURL), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case CHROME_REMOTE:
                capabilities.setBrowserName("chrome");
                ChromeOptions remoteOptions = new ChromeOptions();
                remoteOptions.addArguments("--disable-popup-blocking");
                remoteOptions.addArguments("--disable-extensions");
                remoteOptions.merge(capabilities);
                try {
                    driver = new RemoteWebDriver(new URL(hubURL), remoteOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case CHROME:
            default: {
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getRuntimeConfiguration().getChromeDriverPath());
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-extensions");
                options.merge(capabilities);
                driver = new ChromeDriver(options);
            }
        }
        driver.get(FileReaderManager.getInstance().getRuntimeConfiguration().getApplicationUrl());
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getRuntimeConfiguration().getImplicitlyWait(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
}


    public void closeDriver(){
        driver.close();
    }

    public void quitDriver(){
        driver.quit();
    }

}
