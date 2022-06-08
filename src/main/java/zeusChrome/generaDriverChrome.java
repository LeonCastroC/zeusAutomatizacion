package zeusChrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.fileProperties;

import static java.lang.Thread.sleep;

public class generaDriverChrome {
    public static WebDriver chromeDriver;
    public static fileProperties archivo = new fileProperties();
    public static WebDriver generaDriverChrome(){
        String driverPathChrome = "drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPathChrome);
        chromeDriver = new ChromeDriver();
        chromeDriver.get(archivo.getProperty().getProperty("url"));
        return chromeDriver;
    }

    public WebDriver ejecutaLoginChrome () throws InterruptedException {
        //Genera el controlador
        generaDriverChrome();
        sleep(3000);
        //Inicio de sesión
        chromeDriver.findElement(By.xpath("/html/body/div[1]/header[1]/div/div[1]/div[2]/a[1]")).click();
        sleep(2000);
        chromeDriver.findElement(By.xpath("//*[@id='user']")).sendKeys(archivo.getProperty().getProperty("usuario"));
        sleep(2000);
        chromeDriver.findElement(By.xpath("//*[@id='login']")).click();
        sleep(2000);
        chromeDriver.findElement(By.xpath("//*[@id='password']")).sendKeys(archivo.getProperty().getProperty("password"));
        sleep(2000);
        chromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/section/div[2]/form/div[2]/button/span")).click();
        sleep(5000);
        return chromeDriver;
    }
    public void ejecutaLogoutChrome () throws InterruptedException {
        chromeDriver.findElement(By.xpath("//*[@id='header']/div[3]/button[3]/div/span")).click();
        sleep(3000);
        chromeDriver.findElement(By.xpath("/html/body/div[3]/div/section/div/nav/ul/li[8]/button/span")).click();
        sleep(4000);
        chromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/section/form/button/span")).click();
        sleep(6000);
        chromeDriver.close();
    }
}
