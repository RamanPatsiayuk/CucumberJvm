package io.cucumber;

import io.cucumber.core.WebDriverFactory;
import io.cucumber.core.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    @Before
    public void setUpt() {
        String browserName = "firefox";
        WebDriver driver = WebDriverFactory.createWebDriverInstance(browserName);
        WebDriverManager.setWebDriver(driver);

    }

    @After
    public void tearDown() {
        WebDriver driver = WebDriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
