package zeusInternetExplorer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.fileProperties;

import static java.lang.Thread.sleep;

public class generaInternetExplorer {

    public static WebDriver ieDriver;
    public static fileProperties archivo = new fileProperties();

    public static WebDriver generaDriverInternetExplorer(){
        String driverPathIe = "drivers/IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", driverPathIe);
        ieDriver = new InternetExplorerDriver();
        ieDriver.get(archivo.getProperty().getProperty("url"));
        return ieDriver;
    }

    public WebDriver ejecutaLoginInternetExplorer () throws InterruptedException {
        //Genera el controlador
        generaDriverInternetExplorer();
        sleep(3000);
        //Inicio de sesión
        ieDriver.findElement(By.xpath("/html/body/div[1]/header[1]/div/div[1]/div[2]/a[1]")).click();
        sleep(2000);
        ieDriver.findElement(By.xpath("//*[@id='user']")).sendKeys(archivo.getProperty().getProperty("usuario"));
        sleep(2000);
        ieDriver.findElement(By.xpath("//*[@id='login']")).click();
        sleep(2000);
        ieDriver.findElement(By.xpath("//*[@id='password']")).sendKeys(archivo.getProperty().getProperty("password"));
        sleep(2000);
        ieDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/section/div[2]/form/div[2]/button/span")).click();
        sleep(5000);
        return ieDriver;
    }
    public void ejecutaLogoutInternetExplorer () throws InterruptedException {
        ieDriver.findElement(By.xpath("//*[@id='header']/div[3]/button[3]/div/span")).click();
        sleep(3000);
        ieDriver.findElement(By.xpath("/html/body/div[3]/div/section/div/nav/ul/li[8]/button/span")).click();
        sleep(4000);
        ieDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/section/form/button/span")).click();
        sleep(6000);
        ieDriver.close();
    }
}
