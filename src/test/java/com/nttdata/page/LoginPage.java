package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {

    //Localizadores de elementos
    public static By loginLink = By.xpath("//a[contains(@href, '/iniciar-sesion') and @title='Acceda a su cuenta de cliente']");
    public static By emailInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By errorMessage = By.cssSelector("li.alert.alert-danger");

}
