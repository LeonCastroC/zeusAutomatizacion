package zeus;

import utils.fileProperties;
import zeusChrome.generaDriverChrome;
import zeusEdge.generaDriverEdge;
import zeusFirefox.generaDriverFirefox;
import zeusInternetExplorer.generaInternetExplorer;

public class automatizacionIndex {
    public static void main(String[] args) throws InterruptedException {
        fileProperties file = new fileProperties();
        boolean varChrome, varFirefox, varEdge, varIE;
        varChrome = Boolean.parseBoolean(file.getProperty().getProperty("chrome"));
        varFirefox = Boolean.parseBoolean(file.getProperty().getProperty("firefox"));
        varEdge = Boolean.parseBoolean(file.getProperty().getProperty("edge"));
        varIE = Boolean.parseBoolean(file.getProperty().getProperty("internetExplorer"));
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

    }
}
