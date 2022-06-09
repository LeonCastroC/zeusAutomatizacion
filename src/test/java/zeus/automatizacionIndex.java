package zeus;

import org.openqa.selenium.safari.SafariDriver;
import utils.fileProperties;
import zeusChrome.generaDriverChrome;
import zeusEdge.generaDriverEdge;
import zeusFirefox.generaDriverFirefox;
import zeusInternetExplorer.generaInternetExplorer;
import zeusSafari.generaDriverSafari;

import java.io.IOException;

public class automatizacionIndex {
    public static void main(String[] args) throws Exception {
        fileProperties file = new fileProperties();
        boolean varChrome, varFirefox, varEdge, varIE, varSafari;
        varChrome = Boolean.parseBoolean(file.getProperty().getProperty("chrome"));
        varFirefox = Boolean.parseBoolean(file.getProperty().getProperty("firefox"));
        varEdge = Boolean.parseBoolean(file.getProperty().getProperty("edge"));
        varIE = Boolean.parseBoolean(file.getProperty().getProperty("internetExplorer"));
        varSafari = Boolean.parseBoolean(file.getProperty().getProperty("safari"));
        if(varChrome) {
            generaDriverChrome driverChrome = new generaDriverChrome();
            driverChrome.ejecutaLoginChrome();
            driverChrome.ejecutaLogoutChrome();
        }
        if(varFirefox) {
            generaDriverFirefox driverFirefox = new generaDriverFirefox();
            driverFirefox.ejecutaLoginFirefox();
            driverFirefox.ejecutaLogoutFirefox();
        }
        if(varEdge) {
            generaDriverEdge driverEdge = new generaDriverEdge();
            driverEdge.ejecutaLoginEdge();
            driverEdge.ejecutaLogoutEdge();
        }
        if (varIE) {
            generaInternetExplorer driverIe = new generaInternetExplorer();
            driverIe.ejecutaLoginInternetExplorer();
            driverIe.ejecutaLogoutInternetExplorer();
        }
        if(varSafari) {
            generaDriverSafari driverSafari = new generaDriverSafari();
            driverSafari.ejecutaLoginSafari();
        }

    }
}
