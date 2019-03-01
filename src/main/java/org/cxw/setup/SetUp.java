package org.cxw.setup;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp {

    private static WebDriver driver = setupDriver();
    //final static Logger logger = Logger.getLogger(ClientPage.class);
    
    public static WebDriver setupDriver() {
    	//BasicConfigurator.configure();
    	if (driver == null || driver.toString().contains("(null)")) {
            String driverPath = PropertyFile.readProperty("chrome.driver.path");
            System.setProperty("webdriver.chrome.driver", driverPath);

            WebDriver driver = new ChromeDriver();
            // driver = new FirefoxDriver();
            // driver.get(baseUrl);
            String baseUrl = PropertyFile.readProperty("baseURL");
            driver.get(baseUrl);
            driver.manage().window().maximize();
            return driver;
        } else {
            return driver;
        }
    }

    public static void quitDriver() {
        driver.close();
        driver.quit();
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public void pauseDriver(int i) {
        driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
    }

}
