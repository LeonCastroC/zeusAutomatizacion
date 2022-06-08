package zeusEdge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utils.fileProperties;

import static java.lang.Thread.sleep;

public class generaDriverEdge {

    public static WebDriver edgeDriver;
    public static fileProperties archivo = new fileProperties();

    public static WebDriver generaEdge(){
        String driverPathEdge = "drivers/edgedriver.exe";
        System.setProperty("webdriver.edge.driver", driverPathEdge);
        edgeDriver = new EdgeDriver();
        edgeDriver.get(archivo.getProperty().getProperty("url"));
        return edgeDriver;
    }

    public WebDriver ejecutaLoginEdge () throws InterruptedException {
        //Genera el controlador
        generaEdge();
        sleep(2000);
        //Inicio de sesión
        edgeDriver.findElement(By.xpath("/html/body/div[1]/header[1]/div/div[1]/div[2]/a[1]")).click();
        sleep(2000);
        edgeDriver.findElement(By.xpath("//*[@id='user']")).sendKeys(archivo.getProperty().getProperty("usuario"));
        sleep(2000);
        edgeDriver.findElement(By.xpath("//*[@id='login']")).click();
        sleep(2000);
        edgeDriver.findElement(By.xpath("//*[@id='password']")).sendKeys(archivo.getProperty().getProperty("password"));
        sleep(2000);
        edgeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/section/div[2]/form/div[2]/button/span")).click();
        sleep(5000);
        return edgeDriver;
    }
    public void ejecutaLogoutEdge () throws InterruptedException {
        edgeDriver.findElement(By.xpath("//*[@id='header']/div[3]/button[3]/div/span")).click();
        sleep(3000);
        edgeDriver.findElement(By.xpath("/html/body/div[3]/div/section/div/nav/ul/li[8]/button/span")).click();
        sleep(4000);
        edgeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/section/form/button/span")).click();
        sleep(6000);
        edgeDriver.close();
    }

}
