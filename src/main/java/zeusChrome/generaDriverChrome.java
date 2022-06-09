package zeusChrome;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TomarEvidencias;
import utils.fileProperties;

import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class generaDriverChrome {
    public static WebDriver chromeDriver;
    private static String versionSO = System.getProperty("os.name").toLowerCase();
    public static fileProperties archivo = new fileProperties();

    TomarEvidencias tomarEvidencias = new TomarEvidencias();
    static String driverPathChrome;
    public static WebDriver generaDriverChrome(){
        if(versionSO.contains("windows")) {
            driverPathChrome = "drivers/windows/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPathChrome);
        }
        if(versionSO.contains("mac")) {
            driverPathChrome = "drivers/mac/chromedriver";
            System.setProperty("webdriver.chrome.driver", driverPathChrome);
        }
        chromeDriver = new ChromeDriver();
        chromeDriver.get(archivo.getProperty().getProperty("url"));
        return chromeDriver;
    }

    public WebDriver ejecutaLoginChrome () throws Exception {
        //Genera el controlador
        generaDriverChrome();
        sleep(3000);
        //Inicio de sesión
        chromeDriver.findElement(By.cssSelector(".HlPFP > .UiEmailSignupstyles__InputEmail-sc-9nggyw-1")).click();
        sleep(2000);
        tomarEvidencias.tomaEvidenciaFoto(chromeDriver);
        chromeDriver.findElement(By.cssSelector(".HlPFP > .UiEmailSignupstyles__InputEmail-sc-9nggyw-1")).sendKeys(archivo.getProperty().getProperty("usuario"));
        sleep(2000);
        tomarEvidencias.tomaEvidenciaFoto(chromeDriver);
        chromeDriver.findElement(By.cssSelector(".gToSzH > button")).click();
        sleep(2000);
        tomarEvidencias.tomaEvidenciaFoto(chromeDriver);
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
