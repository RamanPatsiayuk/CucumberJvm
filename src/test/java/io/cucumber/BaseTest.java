package io.cucumber;

import io.cucumber.core.EventHandler;
import io.cucumber.core.WebDriverFactory;
import io.cucumber.core.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public abstract class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUpt() {
        String browserName = "firefox";
        driver = WebDriverFactory.createWebDriverInstance(browserName);
        WebDriverManager.setWebDriver(driver);
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        EventHandler handler = new EventHandler();
        eventDriver.register(handler);
    }

    @After
    public void tearDown() {
        driver = WebDriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
