package dummy.driverManager;

import dummy.constants.BrowserNames;

public class DriverManagerFactory {

    public static DriverManagerAbstract getManager(BrowserNames driverType){
        switch (driverType){
            case CHROME:
                return new ChromeManager();
            case FIREFOX:
                return new FirefoxManager();
            default:
            	throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }
}
