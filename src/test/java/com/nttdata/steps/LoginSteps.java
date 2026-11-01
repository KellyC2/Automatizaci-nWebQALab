package com.nttdata.steps;

import com.nttdata.page.HomePage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void typeUser(String user) {
        WebDriverWait loginWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginWait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.emailInput))
                .sendKeys(user);
    }

    public void typePassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.passInput))
                .sendKeys(password);
    }

    public void login() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginPage.loginButton))
                .click();
    }

    public void ingresoUsuarioYContraseña(String user, String password) {
        typeUser(user);
        typePassword(password);
        login();
    }

    public boolean isLoginFormDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(LoginPage.emailInput)
        ).isDisplayed();
    }
}