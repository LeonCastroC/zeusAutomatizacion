package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TomarEvidencias {
    private int counterStep = 1;
    private static WebDriver driver;


    public void tomaEvidenciaFoto(WebDriver driver) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("_ddMMyy_HHmmss");
        Date date = new Date();
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./src/Evidencias/Imagenes/paso"+counterStep+formatter.format(date)+".png"));

        counterStep += 1;

    }
}
