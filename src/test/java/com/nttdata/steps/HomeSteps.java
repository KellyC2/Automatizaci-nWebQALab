package com.nttdata.steps;

import com.nttdata.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomeSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void clickLoginLink() {

        wait.until(ExpectedConditions.elementToBeClickable(HomePage.loginLink))
                .click();

        wait.until(ExpectedConditions.urlContains("iniciar-sesion"));
    }
}