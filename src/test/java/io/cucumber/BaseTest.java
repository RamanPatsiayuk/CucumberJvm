package io.cucumber;

import io.cucumber.core.WebDriverFactory;
import io.cucumber.core.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUpt() {
        String browserName = "firefox";
        driver = WebDriverFactory.createWebDriverInstance(browserName);
        WebDriverManager.setWebDriver(driver);

    }

    @After
    public void tearDown() {
        driver = WebDriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
