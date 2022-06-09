package zeusFirefox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.fileProperties;

import static java.lang.Thread.sleep;

public class generaDriverFirefox {
    public static WebDriver firefoxDriver;
    private static String versionSO = System.getProperty("os.name").toLowerCase();
    public static fileProperties archivo = new fileProperties();
    static String driverPathFirefox;

    public static WebDriver generaDriverFirefox(){
        if(versionSO.contains("windows")) {
            driverPathFirefox = "drivers/windows/geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", driverPathFirefox);
        }
        if(versionSO.contains("mac")) {
            driverPathFirefox = "drivers/mac/geckodriver";
            System.setProperty("webdriver.gecko.driver", driverPathFirefox);
        }
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.get(archivo.getProperty().getProperty("url"));
        return firefoxDriver;
    }

    public WebDriver ejecutaLoginFirefox () throws InterruptedException {
        //Genera el controlador
        generaDriverFirefox();
        sleep(2000);
        //Inicio de sesión
        firefoxDriver.findElement(By.xpath("/html/body/div[1]/header[1]/div/div[1]/div[2]/a[1]")).click();
        sleep(2000);
        firefoxDriver.findElement(By.xpath("//*[@id='user']")).sendKeys(archivo.getProperty().getProperty("usuario"));
        sleep(2000);
        firefoxDriver.findElement(By.xpath("//*[@id='login']")).click();
        sleep(2000);
        firefoxDriver.findElement(By.xpath("//*[@id='password']")).sendKeys(archivo.getProperty().getProperty("password"));
        sleep(2000);
        firefoxDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/section/div[2]/form/div[2]/button/span")).click();
        sleep(5000);
        return firefoxDriver;
    }
    public void ejecutaLogoutFirefox () throws InterruptedException {
        firefoxDriver.findElement(By.xpath("//*[@id='header']/div[3]/button[3]/div/span")).click();
        sleep(3000);
        firefoxDriver.findElement(By.xpath("/html/body/div[3]/div/section/div/nav/ul/li[8]/button/span")).click();
        sleep(4000);
        firefoxDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/section/form/button/span")).click();
        sleep(2000);
        firefoxDriver.close();
    }
}
