package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setup() {
        System.out.println("Launching Browser...");
        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
        System.out.println("Closing Browser...");
        DriverFactory.quitDriver();
    }
}