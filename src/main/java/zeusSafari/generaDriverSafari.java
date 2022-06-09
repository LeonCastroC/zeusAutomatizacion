package zeusSafari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.fileProperties;

import static java.lang.Thread.sleep;

public class generaDriverSafari {
    public static WebDriver safariDriver;
    public static fileProperties archivo = new fileProperties();
    static String driverPathSafari;

    public static WebDriver generaDriverSafari(){
            //String driverPathSafari = "drivers/mac/geckodriver";
        //System.setProperty("webdriver.gecko.driver", driverPathSafari);

        safariDriver = new SafariDriver();
        //safariDriver.get(archivo.getProperty().getProperty("url"));
        safariDriver.navigate().to(archivo.getProperty().getProperty("url"));
        return safariDriver;
    }

    public WebDriver ejecutaLoginSafari () throws Exception {
        generaDriverSafari();
        sleep(3000);
        safariDriver.close();
        return safariDriver;
    }
}
