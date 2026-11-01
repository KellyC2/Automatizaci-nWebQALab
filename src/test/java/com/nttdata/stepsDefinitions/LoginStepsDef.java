
package com.nttdata.stepsDefinitions;

import com.nttdata.steps.HomeSteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.*;

public class LoginStepsDef {

    private WebDriver driver;

    private LoginSteps loginSteps(WebDriver driver) {
        return new LoginSteps(driver);
    }
    private HomeSteps homeSteps (WebDriver driver) {
        return new HomeSteps(driver);
    }

    @Dado("estoy en la página de la tienda")
    public void estoy_en_la_pagina_de_la_tienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @Y("me logueo con mi usuario: {string} y constraseña: {string}")
    public void meLogueoConMiUsuarioYConstraseña(String email, String contraseña) {
        homeSteps(driver).clickLoginLink();
        loginSteps(driver).ingresoUsuarioYContraseña(email, contraseña);
        screenShot();
    }

}