package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    WebDriver driver;

    public Driver(){
        String path = "C:\\Users\\Adrian\\Documents\\curso qa\\ejercicios java\\chromedriver-win64\\chromedriver";
        System.setProperty("webDriver.chrome.driver", path);
        //this.driver = new ChromeDriver();
        this.driver = new FirefoxDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
